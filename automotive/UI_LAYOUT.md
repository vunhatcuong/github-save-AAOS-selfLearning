## Layout Design

Target: Android Automotive landscape display.

Design style:
- Simple and minimal
- Dark theme
- Large controls suitable for IVI screen
- Avoid unnecessary cards, icons and animations
- Focus on engineering/testing usage

---

### 1. activity_vehicle.xml

Purpose: Set vehicle properties and monitor the actual values received from callbacks.

Layout: Two-column screen.

```text
┌─────────────────────────────────────────────────────────────┐
│ VehicleLab - Vehicle Property                              │
├──────────────────────────────┬──────────────────────────────┤
│ CONTROL                      │ LIVE MONITOR                 │
│                              │                              │
│ Speed                        │ Speed          60 km/h       │
│ [ 60        ] [ SET ]        │                              │
│                              │ Gear           D             │
│ Gear                         │                              │
│ [ P | R | N | D ]            │ Temperature    22 °C         │
│                              │                              │
│ HVAC Temperature             │ Door FL        OPEN          │
│ [ - ] 22 °C [ + ]            │ Door FR        CLOSED        │
│                              │                              │
│ Door                         │ Light          ON            │
│ [FL] [FR] [RL] [RR]          │                              │
│ [ OPEN ] [ CLOSE ]           │                              │
│                              │                              │
│ Light                        │                              │
│ [ OFF | ON ]                 │                              │
│                              │                              │
└──────────────────────────────┴──────────────────────────────┘
```

#### Left side — Control

Allows the tester to SET vehicle properties.

Controls:

- Speed
    - Number input
    - SET button

- Gear
    - P
    - R
    - N
    - D

- HVAC Temperature
    - Decrease button
    - Current target temperature
    - Increase button

- Door
    - Select FL / FR / RL / RR
    - OPEN
    - CLOSE

- Light
    - ON
    - OFF

#### Right side — Live Monitor

Displays actual property values received from `CarPropertyManager` callbacks.

Display:

- Speed
- Gear
- HVAC Temperature
- FL Door
- FR Door
- RL Door
- RR Door
- Light

Important:

The Live Monitor must display callback values, not the value immediately entered by the user.

Example:

```text
User SET Speed = 60
        ↓
CarPropertyManager
        ↓
VHAL
        ↓
Property Callback
        ↓
Live Monitor = 60
```

---

### 2. activity_event.xml

Purpose: Trigger notification/events through OEM VAPI.

Keep this screen very simple.

```text
┌─────────────────────────────────────────────────────────────┐
│ VehicleLab - Event Trigger                                 │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│ Event Type                                                  │
│                                                             │
│ [ Notification Type ▼ ]                                     │
│                                                             │
│ Title                                                       │
│ [________________________________________]                   │
│                                                             │
│ Message                                                     │
│ [________________________________________]                   │
│ [________________________________________]                   │
│                                                             │
│                  [ TRIGGER ]                                │
│                                                             │
│ ──────────────────────────────────────────────────────────  │
│                                                             │
│ RESULT                                                      │
│                                                             │
│ Status:    SUCCESS                                          │
│ Response:  OK                                               │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

#### Input

- Notification/Event Type
- Title
- Message
- Trigger button

#### Output

Display only basic VAPI result:

- Success / Failed
- Response message

No complex event history or additional panels are required for the first version.

---

## Layout Files

```text
res/
└── layout/
    ├── activity_vehicle.xml
    └── activity_event.xml
```

Mapping:

```text
activity_vehicle.xml
        ↕
VehicleActivity.kt
        ↕
VehicleViewModel.kt
        ↕
CarPropertyDataSource.kt


activity_event.xml
        ↕
EventActivity.kt
        ↕
EventViewModel.kt
        ↕
VapiDataSource.kt
```