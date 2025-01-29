# To-Do App

## Overview

The **To-Do App** is a simple task management application built using **RoomDB** with **MVVM architecture**. It allows users to **add, edit, and manage tasks** efficiently while supporting both **light and dark themes**.

## Features

- **Add To-Do Items**: Users can create new tasks.
- **Edit To-Do Items**: Modify existing tasks.
- **Persistent Storage**: Data is stored locally using RoomDB.
- **MVVM Architecture with Jetpack Compose**: Ensures clean separation of concerns.
- **LiveData & Compose Integration**: For reactive UI updates.
- **Light and Dark Theme Support**: Screenshots provided below.

## Screenshots

<table>
  <tr>
    <td><strong>Adding a To-Do Item (Light Mode)</strong></td>
    <td><strong>Adding a To-Do Item (Dark Mode)</strong></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/637ab763-7134-4255-b302-e78bb3cb7ca6" width="45%"></td>
    <td><img src="https://github.com/user-attachments/assets/8cb77e6d-1e4e-47bd-bf2c-43c23695d270" width="45%"></td>
  </tr>
  <tr>
    <td><strong>Editing a To-Do Item (Light Mode)</strong></td>
    <td><strong>Editing a To-Do Item (Dark Mode)</strong></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/79ee67e1-fe96-413d-a5ce-b8d8cfcc9629" width="45%"></td>
    <td><img src="https://github.com/user-attachments/assets/fe21308d-1cb7-42b6-8936-56e49f7bf076" width="45%"></td>
  </tr>
</table>


## Tech Stack

- **Framework**: Jetpack Compose
- **Database**: RoomDB
- **Architecture**: MVVM
- **UI**: Jetpack Compose

## Dependencies

For more details, refer to:
- [Migrate to KSP](https://developer.android.com/build/migrate-to-ksp#add-ksp)
- [RoomDB Releases](https://developer.android.com/jetpack/androidx/releases/room)

Add the following dependencies in your **build.gradle.kts**:

```kotlin
implementation("androidx.compose.runtime:runtime-livedata:1.7.6")

val room_version = "2.6.1"

implementation("androidx.room:room-runtime:$room_version")
ksp("androidx.room:room-compiler:$room_version")
```

## Setup Instructions

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/todo-app.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle dependencies.
4. Run the app on an emulator or a physical device.

## Future Enhancements

- **Task Reminders**
- **Category-based Organization**
- **Cloud Sync Support**

## License

This project is open-source and free to use.

---

For any issues or suggestions, feel free to open an issue or contribute! 🚀

