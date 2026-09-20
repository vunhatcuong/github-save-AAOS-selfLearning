package com.example.my_first_aaos_v1.ui.vehicle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_first_aaos_v1.data.vehicle.CarPropertyDataSource

/**
 * ViewModel quản lý dữ liệu cho màn hình Điều khiển xe.
 */
class VehicleViewModel(private val dataSource: CarPropertyDataSource) : ViewModel() {

    // --- LiveData cho các giá trị thực tế từ xe (Monitor) ---
    private val _currentSpeed = MutableLiveData<Float>()
    val currentSpeed: LiveData<Float> = _currentSpeed

    private val _currentGear = MutableLiveData<Int>()
    val currentGear: LiveData<Int> = _currentGear

    private val _currentTemp = MutableLiveData<Float>()
    val currentTemp: LiveData<Float> = _currentTemp

    private val _doorStatus = MutableLiveData<Map<Int, Boolean>>() // ID cửa -> Trạng thái
    val doorStatus: LiveData<Map<Int, Boolean>> = _doorStatus

    private val _lightStatus = MutableLiveData<Boolean>()
    val lightStatus: LiveData<Boolean> = _lightStatus

    // --- Hàm gửi lệnh điều khiển (Control) ---

    fun setSpeed(speed: Float) {
        // ID: PERF_VEHICLE_SPEED (Thường là chỉ đọc, nhưng ở đây giả lập set cho tester)
        dataSource.setProperty(291504647, 0, speed)
    }

    fun setGear(gear: Int) {
        // ID: GEAR_SELECTION
        dataSource.setProperty(289408000, 0, gear)
    }

    fun setTemperature(temp: Float) {
        // ID: HVAC_TEMPERATURE_SET
        dataSource.setProperty(358604818, 0, temp)
    }

    fun setDoorLock(doorAreaId: Int, locked: Boolean) {
        // ID: DOOR_LOCK
        dataSource.setProperty(289408514, doorAreaId, locked)
    }

    fun setLightSwitch(on: Boolean) {
        // ID: HEADLIGHTS_SWITCH (0: Off, 1: On)
        val value = if (on) 1 else 0
        dataSource.setProperty(289408513, 0, value)
    }

    // --- Hàm cập nhật dữ liệu khi nhận được Callback từ xe ---

    fun onSpeedChanged(speed: Float) {
        _currentSpeed.postValue(speed)
    }

    fun onGearChanged(gear: Int) {
        _currentGear.postValue(gear)
    }

    fun onTemperatureChanged(temp: Float) {
        _currentTemp.postValue(temp)
    }

    fun onLightChanged(on: Boolean) {
        _lightStatus.postValue(on)
    }
}
