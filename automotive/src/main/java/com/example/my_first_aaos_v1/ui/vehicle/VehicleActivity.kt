package com.example.my_first_aaos_v1.ui.vehicle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.my_first_aaos_v1.data.vehicle.CarPropertyDataSource

/**
 * Màn hình chính điều khiển và giám sát các thuộc tính của xe.
 */
class VehicleActivity : AppCompatActivity() {

    private lateinit var viewModel: VehicleViewModel
    private var selectedDoorAreaId: Int = 1 // Mặc định là cửa Front Left (FL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Link tới file layout XML đã tạo
        // setContentView(R.layout.activity_vehicle)

        val dataSource = CarPropertyDataSource(this)
        viewModel = VehicleViewModel(dataSource)

        setupControlUI()
        setupMonitorUI()
    }

    /**
     * KHUNG HÀM: Kết nối các nút bấm ĐIỀU KHIỂN (Bên trái giao diện).
     * Bạn hãy thực hiện findViewById và setOnClickListener tại đây.
     */
    private fun setupControlUI() {
        // --- Speed Control ---
        // btn_set_speed -> viewModel.setSpeed(edit_speed.text)

        // --- Gear Control ---
        // btn_gear_p -> viewModel.setGear(1) // 1: Park
        // btn_gear_r -> viewModel.setGear(2) // 2: Reverse
        // btn_gear_n -> viewModel.setGear(3) // 3: Neutral
        // btn_gear_d -> viewModel.setGear(4) // 4: Drive

        // --- HVAC Control ---
        // btn_temp_minus -> viewModel.setTemperature(current - 0.5f)
        // btn_temp_plus -> viewModel.setTemperature(current + 0.5f)

        // --- Door Control ---
        // btn_door_fl/fr/rl/rr -> Cập nhật selectedDoorAreaId
        // btn_door_open -> viewModel.setDoorLock(selectedDoorAreaId, false)
        // btn_door_close -> viewModel.setDoorLock(selectedDoorAreaId, true)

        // --- Light Control ---
        // btn_light_off -> viewModel.setLightSwitch(false)
        // btn_light_on -> viewModel.setLightSwitch(true)
    }

    /**
     * KHUNG HÀM: Lắng nghe dữ liệu để cập nhật GIÁM SÁT (Bên phải giao diện).
     */
    private fun setupMonitorUI() {
        // Quan sát Tốc độ
        viewModel.currentSpeed.observe(this) { speed ->
            updateSpeedMonitor(speed)
        }

        // Quan sát Số (Gear)
        viewModel.currentGear.observe(this) { gear ->
            updateGearMonitor(gear)
        }

        // Quan sát Nhiệt độ
        viewModel.currentTemp.observe(this) { temp ->
            updateTempMonitor(temp)
        }

        // Quan sát Đèn
        viewModel.lightStatus.observe(this) { isOn ->
            updateLightMonitor(isOn)
        }
    }

    // --- Các hàm hỗ trợ cập nhật UI hiển thị ---
    
    private fun updateSpeedMonitor(speed: Float) {
        // monitor_speed.text = "$speed km/h"
    }

    private fun updateGearMonitor(gear: Int) {
        // monitor_gear.text = khi gear=1 là "P", gear=2 là "R"...
    }

    private fun updateTempMonitor(temp: Float) {
        // monitor_temp.text = "$temp °C"
    }

    private fun updateLightMonitor(isOn: Boolean) {
        // monitor_light.text = if (isOn) "ON" else "OFF"
    }
}
