# VehicleLab Design Tokens

## Design Direction

Modern minimal automotive engineering UI.

- Primary tone: Black / White / Gray
- Dark theme
- Clean and technical appearance
- High contrast
- Large controls for automotive display
- Minimal use of color
- Avoid gradients, excessive shadows and decorative elements

---

## Colors

```text
Background          #0D0D0D
Surface             #161616
Surface Secondary   #202020
Border              #333333

Text Primary        #FFFFFF
Text Secondary      #A0A0A0
Text Disabled       #606060

Primary Action      #FFFFFF
Primary Action Text #000000

Success             #4CAF50
Error               #F44336
Warning             #FFC107
```

Use Success / Error / Warning only for system status and feedback.

Normal UI should remain black, white and gray.

---

## Typography

Use Android default sans-serif font.

```text
Screen Title     24sp / Medium
Section Title    18sp / Medium
Property Name    16sp / Regular
Property Value   20sp / Medium
Body             14sp / Regular
Button           16sp / Medium
Caption          12sp / Regular
```

Property values should be visually stronger than labels.

Example:

```text
Speed
60 km/h
```

---

## Spacing

Use an 8dp spacing system.

```text
4dp    Extra Small
8dp    Small
16dp   Medium
24dp   Large
32dp   Extra Large
```

Default screen padding:

```text
24dp
```

Default distance between controls:

```text
16dp
```

---

## Components

### Button

Minimum height:

```text
48dp
```

Primary button:

```text
Background: #FFFFFF
Text:       #000000
Radius:     8dp
```

Secondary button:

```text
Background: #202020
Text:       #FFFFFF
Border:     #333333
Radius:     8dp
```

Selected state:

```text
Background: #FFFFFF
Text:       #000000
```

---

### Input

```text
Height:     48dp
Background: #161616
Text:       #FFFFFF
Border:     #333333
Radius:     8dp
Padding:    12dp
```

---

### Panel

Use panels only to separate major sections.

```text
Background: #161616
Radius:     12dp
Padding:    20dp
```

Avoid putting every property inside a separate card.

---

## Vehicle Screen

Use a two-column layout.

```text
┌───────────────────────────────────────────────────────┐
│ VehicleLab                              ● Connected  │
├──────────────────────────┬────────────────────────────┤
│                          │                            │
│ CONTROL                  │ LIVE MONITOR               │
│                          │                            │
│ Speed                    │ Speed                      │
│ [ 60 ]       [ SET ]     │ 60 km/h                    │
│                          │                            │
│ Gear                     │ Gear                       │
│ [P] [R] [N] [D]          │ D                          │
│                          │                            │
│ Temperature              │ Temperature                │
│ [-]   22°C   [+]         │ 22°C                       │
│                          │                            │
│ Door                     │ FL Door     OPEN           │
│ [FL][FR][RL][RR]          │ FR Door     CLOSED         │
│ [OPEN]      [CLOSE]      │ RL Door     CLOSED         │
│                          │ RR Door     CLOSED         │
│ Light                    │                            │
│ [OFF]        [ON]        │ Light       ON             │
│                          │                            │
└──────────────────────────┴────────────────────────────┘
```

Control and monitor areas should have approximately equal width.

---

## Event Screen

Keep the Event screen focused.

```text
┌───────────────────────────────────────────────────────┐
│ VehicleLab - Event Trigger                           │
├───────────────────────────────────────────────────────┤
│                                                       │
│ Event Type                                            │
│ [ Notification Type ▼ ]                               │
│                                                       │
│ Title                                                 │
│ [________________________________________]             │
│                                                       │
│ Message                                               │
│ [________________________________________]             │
│ [________________________________________]             │
│                                                       │
│                    [ TRIGGER ]                        │
│                                                       │
│ ───────────────────────────────────────────────────   │
│                                                       │
│ RESULT                                                │
│                                                       │
│ Status      SUCCESS                                   │
│ Response    OK                                        │
│                                                       │
└───────────────────────────────────────────────────────┘
```

---

## Status

Connection status:

```text
● Connected
● Disconnected
```

Use color only for the status indicator:

```text
Connected      Green
Disconnected   Red
```

Do not use large colored backgrounds.

---

## UI Rules

1. Black, white and gray are the primary colors.
2. Use color only to communicate status.
3. Keep the interface flat and minimal.
4. Avoid gradients.
5. Avoid unnecessary icons.
6. Avoid excessive cards and shadows.
7. Use large touch targets.
8. Keep SET controls visually separated from callback values.
9. Live Monitor always displays actual callback data.
10. Maintain consistent spacing, typography and component sizes across screens.

---

## AI Implementation Instruction

When creating or modifying VehicleLab UI:

1. Read this file before editing any layout.
2. Follow the defined colors, spacing and typography.
3. Do not introduce new colors unless required for status.
4. Keep the UI optimized for landscape Android Automotive displays.
5. Prioritize readability and engineering functionality over decoration.