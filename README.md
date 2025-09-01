## POKE API
A modern Android application built with Jetpack Compose that displays a collection of Pokemon characters fetched from the [PokeAPI](https://pokeapi.co/docs/v2#info).

### Features
- **Pokemon display**: Shows Pokemon in a responsive 2-column grid layout.
- **Dynamic loading**: Fetches random Pokemon data from the *PokeAPI*.
- **Sorting options**: Multiple sorting capabilities including:
  + sort by name (ascending/descending);
  + sort by moves (ascending/descending).
- **Reload functionality**: Button to refresh and load new random Pokemon.
- **Modern UI**: Clean Material Design 3 interface with dropdown menu for sorting.


### Tech stack
+ **Language**: Kotlin.
+ **UI framework**: Jetpack Compose.
+ **Networking**: Retrofit2 for API calls.
+ **Image loading**: Coil for efficient image loading.
+ **API**: *PokeAPI*.
+ **Data models**: Kotlin data classes with GSON serialization.
+ **State management**: LiveData and Compose state.


### Architecture
The app follows modern Android development practices with *clean separation of concerns, **repository** pattern for data management, **ViewModel** for business logic, **Compose UI** components, and **RESTful API** integration*.


### Dependencies
* **Retrofit2** for HTTP client;
* **GSON** for JSON parsing;
* **Coil** for image loading;
* **Jetpack Compose** for UI;
* **AndroidX Lifecycle** components;
* **Material Design 3** components.


### Installation
1. Clone the repository.
2. Open in Android Studio.
3. Sync Gradle dependencies.
4. Run on device or emulator.


### Screenshots
Below you can see the main interface and functionality of the Pokemon app:

| Main Screen | Sorting Menu |
|-------------|--------------|
| <img src="https://github.com/user-attachments/assets/5d358b06-fc2d-4e9a-a307-ae2c7c9fc312" width="300"/> | <img src="https://github.com/user-attachments/assets/4391482b-c501-40a0-85c2-ffe0ea1a3012" width="300"/> |
| *Main Pokemon list with Reload button*. | *Dropdown menu with various sorting options*. |


### License
Personal project for educational and portfolio purposes.
