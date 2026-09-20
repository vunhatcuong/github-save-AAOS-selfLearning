package com.example.my_first_aaos_v1.ui.event

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.my_first_aaos_v1.data.vapi.VapiDataSource

/**
 * Màn hình kích hoạt các sự kiện thông qua OEM VAPI.
 */
class EventActivity : AppCompatActivity() {

    private lateinit var viewModel: EventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Link tới layout XML
        // setContentView(R.layout.activity_event)

        val dataSource = VapiDataSource()
        viewModel = EventViewModel(dataSource)

        setupUI()
        observeData()
    }

    /**
     * KHUNG HÀM: Kết nối các thành phần nhập liệu và nút bấm.
     */
    private fun setupUI() {
        // --- Input Fields ---
        // spinner_event_type: Chọn loại thông báo
        // edit_event_title: Nhập tiêu đề
        // edit_event_message: Nhập nội dung

        // --- Action ---
        // btn_trigger_event.setOnClickListener {
        //    val name = edit_event_title.text.toString()
        //    viewModel.sendEvent(name)
        // }
    }

    /**
     * Theo dõi phản hồi từ hệ thống để hiển thị kết quả.
     */
    private fun observeData() {
        viewModel.eventStatus.observe(this) { status ->
            // Cập nhật trạng thái lên UI
            updateResultUI(status)
        }
    }

    private fun updateResultUI(status: String) {
        // txt_event_status.text = "SUCCESS"
        // txt_event_response.text = status
    }
}
