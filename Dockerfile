# ==========================================
# Stage 1: Build ứng dụng Spring Boot bằng Gradle
# ==========================================
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

# Sao chép các tệp cấu hình Gradle và wrapper
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Cấp quyền thực thi
RUN chmod +x gradlew

# Sao chép mã nguồn ứng dụng
COPY src src

# Đóng gói tệp JAR (bỏ qua test trong Docker vì bài test đã được kiểm thử ở Job 1)
RUN ./gradlew bootJar -x test --no-daemon

# ==========================================
# Stage 2: Môi trường Runtime gọn nhẹ
# ==========================================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Sao chép file JAR đã build từ Stage 1
COPY --from=builder /app/build/libs/*.jar app.jar

# Cổng mặc định của ứng dụng
EXPOSE 8080

# Lệnh khởi chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
