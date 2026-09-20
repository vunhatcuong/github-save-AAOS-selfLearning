package com.example.my_first_aaos_v1.data.vapi

import android.util.Log

/**
 * Lớp này mô phỏng việc kết nối với OEM VAPI (API riêng của nhà sản xuất xe).
 * Dùng để kích hoạt các sự kiện đặc biệt hoặc thông báo.
 */
class VapiDataSource {

    /**
     * Gửi một yêu cầu kích hoạt sự kiện tới hệ thống xe.
     */
    fun triggerEvent(eventName: String): String {
        Log.d("VapiDataSource", "Đang kích hoạt sự kiện: $eventName")
        
        // Giả lập phản hồi từ server/xe
        return "Thành công: Đã kích hoạt $eventName"
    }

    /**
     * Kiểm tra trạng thái của yêu cầu cuối cùng.
     */
    fun getStatus(): String {
        return "Hệ thống VAPI đang hoạt động bình thường"
    }
}
