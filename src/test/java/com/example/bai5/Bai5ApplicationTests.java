package com.example.bai5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Bai5ApplicationTests {

    @Test
    @DisplayName("Kiểm tra khởi chạy Application Context")
    void contextLoads() {
        assertTrue(true, "Application context loaded successfully");
    }

    @Test
    @DisplayName("Kiểm tra Unit Test thành công - Trạng thái xanh")
    void testSampleLogicSuccess() {
        int expected = 10;
        int actual = 5 + 5;
        assertEquals(expected, actual, "Phép tính cộng phải trả về kết quả 10");
    }

    /*
     * GỢI Ý ĐỂ TEST TRẠNG THÁI SKIPPED CỦA JOB docker-build:
     * Để cố tình làm đứt JUnit Test và xác nhận Job docker-build bị 'Skipped',
     * bạn có thể bỏ chú thích test dưới đây hoặc sửa assertEquals ở trên thành fail:
     *
     * @Test
     * @DisplayName("Test cố tình thất bại")
     * void testDeliberateFailure() {
     *     assertEquals(10, 999, "Cố tình làm fail để kiểm tra Job docker-build bị Skipped");
     * }
     */
}
