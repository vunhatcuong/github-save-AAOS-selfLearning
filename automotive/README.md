# AAOS VehicleLab

A simple Android Automotive engineering tool for controlling and monitoring vehicle properties and triggering vehicle events.

## Features

### Vehicle Control
- Get / Set vehicle properties using `CarPropertyManager`
- Monitor property changes using callbacks
- Supported properties:
    - Speed
    - Gear
    - HVAC Temperature
    - Door
    - Light

### Event Trigger
- Trigger notifications/events through OEM VAPI
- Display VAPI request/response status

---

## Architecture

```text
UI
 ↓
ViewModel
 ↓
DataSource
 ↓
CarPropertyManager / OEM VAPI
```

- **Activity**: Displays UI and handles user interaction.
- **ViewModel**: Provides functions and state for the UI.
- **DataSource**: Communicates directly with AAOS Vehicle API or OEM VAPI.

---

## Project Structure

```text
com.example.vehiclelab
│
├── ui/
│   ├── vehicle/
│   │   ├── VehicleActivity.kt
│   │   └── VehicleViewModel.kt
│   │
│   └── event/
│       ├── EventActivity.kt
│       └── EventViewModel.kt
│
└── data/
    ├── vehicle/
    │   └── CarPropertyDataSource.kt
    │
    └── vapi/
        └── VapiDataSource.kt
        
res/
│
├── layout/
│   ├── activity_vehicle.xml
│   └── activity_event.xml
│
└── values/
    ├── colors.xml
    ├── strings.xml
    └── themes.xml
```

---

## Vehicle Property Flow

```text
VehicleActivity
      ↓
VehicleViewModel
      ↓
CarPropertyDataSource
      ↓
CarPropertyManager
      ↓
CarPropertyService
      ↓
VHAL
      ↓
Emulator / Vehicle
```

Vehicle properties are controlled through `CarPropertyManager`.

UI values are updated from vehicle property callbacks.

```text
SET Property
     ↓
CarPropertyManager
     ↓
VHAL
     ↓
Property Changed
     ↓
Callback
     ↓
CarPropertyDataSource
     ↓
VehicleViewModel
     ↓
VehicleActivity
```

---

## VAPI Flow

```text
EventActivity
      ↓
EventViewModel
      ↓
VapiDataSource
      ↓
OEM VAPI
      ↓
Notification / Event
```

The VAPI module is separated from the Vehicle Property module because it uses the OEM-specific API instead of `CarPropertyManager`.

