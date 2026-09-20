package com.example.my_first_aaos_v1.data.vehicle

import android.car.Car
import android.car.hardware.CarPropertyValue
import android.car.hardware.property.CarPropertyManager
import android.content.Context

/**
 * Lớp này chịu trách nhiệm kết nối trực tiếp với CarPropertyManager của Android Automotive.
 * Đây là nơi chúng ta lấy (Get) và đặt (Set) các thông số của xe như nhiệt độ, tốc độ, v.v.
 */
class CarPropertyDataSource(context: Context) {

    private var carPropertyManager: CarPropertyManager? = null

    init {
        // Khởi tạo đối tượng Car để truy cập vào các dịch vụ của xe
        val car = Car.createCar(context)
        // Lấy CarPropertyManager từ đối tượng Car
        carPropertyManager = car.getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager
    }

    /**
     * Lấy giá trị của một thuộc tính xe (ví dụ: Tốc độ)
     */
    fun getProperty(propertyId: Int, areaId: Int): Any? {
        return try {
            // carPropertyManager?.getProperty sẽ trả về giá trị hiện tại của xe
            carPropertyManager?.getProperty<Any>(propertyId, areaId)?.value
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Thay đổi giá trị của một thuộc tính xe (ví dụ: Tăng nhiệt độ điều hòa)
     */
    fun setProperty(propertyId: Int, areaId: Int, value: Any) {
        try {
            // carPropertyManager?.setProperty gửi lệnh xuống xe (VHAL)
            carPropertyManager?.setProperty(Any::class.java, propertyId, areaId, value)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Đăng ký lắng nghe sự thay đổi của các thuộc tính xe
     */
    fun registerCallback(callback: CarPropertyManager.CarPropertyEventCallback, propertyId: Int, rate: Float) {
        carPropertyManager?.registerCallback(callback, propertyId, rate)
    }

    /**
     * Hủy đăng ký lắng nghe để tiết kiệm tài nguyên
     */
    fun unregisterCallback(callback: CarPropertyManager.CarPropertyEventCallback) {
        carPropertyManager?.unregisterCallback(callback)
    }
}
