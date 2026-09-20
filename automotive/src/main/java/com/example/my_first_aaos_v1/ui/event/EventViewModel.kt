package com.example.my_first_aaos_v1.ui.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_first_aaos_v1.data.vapi.VapiDataSource

/**
 * ViewModel quản lý dữ liệu cho màn hình Kích hoạt sự kiện (OEM VAPI).
 */
class EventViewModel(private val vapiDataSource: VapiDataSource) : ViewModel() {

    private val _eventStatus = MutableLiveData<String>()
    val eventStatus: LiveData<String> = _eventStatus

    /**
     * Gửi lệnh kích hoạt một sự kiện (ví dụ: Gửi thông báo tới xe)
     */
    fun sendEvent(name: String) {
        val result = vapiDataSource.triggerEvent(name)
        _eventStatus.value = result
    }

    /**
     * Cập nhật trạng thái kết nối VAPI
     */
    fun checkVapiStatus() {
        _eventStatus.value = vapiDataSource.getStatus()
    }
}
