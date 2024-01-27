# Android News App with MVVM, Navigation Components, Retrofit, Room, and Coroutines

This repository contains the source code for a news app that demonstrates some concepts in Android development, including the use of MVVM architecture, navigation components, Retrofit, Room, and Coroutines. The app fetches current news from the News API and provides features such as breaking news, saved news, search functionality, and more.

## Features

MVVM Architecture: The app follows the MVVM (Model-View-ViewModel) architecture, providing a clean and organized structure for the codebase.
Navigation Components: Navigation throughout the app is implemented using Android's Navigation Components, offering a robust and intuitive navigation system.
Coroutines: Kotlin Coroutines are used for handling asynchronous tasks, enhancing the app's responsiveness and performance.
Retrofit: The app utilizes Retrofit for making API calls to the News API, fetching the latest news data.
Room Database: Room is integrated to store and retrieve saved articles locally, providing offline access to the user.
Pagination: The breaking news section features a paginated list, loading more news items as the user scrolls down.
Search Functionality: Users can search for news articles based on keywords, and the app dynamically loads results from the API.
Save and Delete Articles: Articles can be saved to the local Room database, and users have the option to delete them, complete with an undo functionality.
Floating Action Button: A floating action button allows users to save articles to their local database easily.
Before running the app, We obtained an API key from News API and insert it into the appropriate configuration file.

## User Interfaces

### Breaking News Screen

![image](https://github.com/ChaimaBouhlel/android-news-app/assets/75532032/937286ed-08f2-490e-95b2-f15cd526b342)

This screenshot represents the main tab: the breaking news available from the API, represented by the BreakingNewsFragment

![image](https://github.com/ChaimaBouhlel/android-news-app/assets/75532032/221022ff-0d2c-4bf2-9196-f22dd46dd079)

This screenshot represents the article view, ArticleFragment, which is displayed on clicking on the article

![image](https://github.com/ChaimaBouhlel/android-news-app/assets/75532032/21d97989-5187-43f6-ae7a-773bbd8c96ef)
![image](https://github.com/ChaimaBouhlel/android-news-app/assets/75532032/7587a591-feda-46c2-9885-183ae854bedb)

This screenshot represents the saved news tab: which contains the articles liked by the user. It is represented by the SavedNewsFragment. The data is stored via the room database. Liked items can be deleted by swiping.

![image](https://github.com/ChaimaBouhlel/android-news-app/assets/75532032/90fc64f5-59cf-4365-ad73-4f8b158af46e)


![image](https://github.com/ChaimaBouhlel/android-news-app/assets/75532032/73a23cd2-13ba-41fe-b0ab-fecd1ba7711e)
This screenshot represents the search tab, represented by the SearchFragment. We can search for news in the entire API, exploring all available news. Upon entering the search query, the app retrieves and displays news articles relevant to the specified term. The implemented pagination feature ensures that as the user scrolls down, additional news items are automatically loaded. The search functionality incorporates a deliberate delay before initiating the search, preventing an immediate flood of requests upon each keystroke.

![image](https://github.com/ChaimaBouhlel/android-news-app/assets/75532032/59890f25-4fc2-42ab-8bbd-85874c714a96)
![image](https://github.com/ChaimaBouhlel/android-news-app/assets/75532032/3fee2deb-8587-40dd-92be-a56e37dd5680)


## Architectural skeleton: MVVM (Model-View-ViewModel) pattern
View Model (UI Package):
The NewsViewModel is responsible for managing and coordinating data related to news articles.
It exposes LiveData objects for Breaking News and Search News:
Two MutableLiveData objects are declared: breakingNews and searchNews, representing the breaking news and search news data, respectively.
It implements functions for getting breaking news and searching news, handling responses, and managing pagination.
It also handles internet connectivity checks.

Repository (Repository Package):
The NewsRepository class is responsible for fetching data from both the local database and the remote data source (API). It acts as an intermediary between the data sources (API and local database) and the rest of the application, particularly the NewsViewModel.

View Model Provider Factory (UI Package):
NewsViewModelProviderFactory inherits from ViewModelProvider.Factory. It is a Factory class used to create instances of the NewsViewModel.

Activity Setup:
In the News Activity, the NewsRepository and NewsViewModelProviderFactory are instantiated.
The NewsViewModel is then instantiated using the ViewModelProvider with the provided factory.

Fragment Setup(ui.fragments):
In each fragment (BreakingNewsFragment, SavedNewsFragment, SearchNewsFragment, and ArticleFragment), the NewsViewModel is instantiated in the onViewCreated method. The fragments use the ViewModelProvider and cast the activity to access the shared NewsViewModel.

Resource Class (util Package):
This is a sealed class that we used to wrap network responses. It has three subclasses: Success (with data), Error (with an error message), and Loading (indicating a loading state). This class helps us differentiate between successful and error responses and handle loading states.

### Design Decisions

MVVM Architecture: MVVM allows for the separation of concerns, making the codebase more modular and maintainable.
LiveData and ViewModel: LiveData ensures that UI components are always up-to-date, and ViewModel survives configuration changes.
Resource Class: The Resource class simplifies handling different states of a network request, making UI logic cleaner.
Repository Pattern: Centralized data access through the repository, promoting a clean architecture.

## Dependencies

Android Architecture Components (ViewModel, LiveData)
Room Database
Coroutine Extensions for Room
Kotlin Coroutines
Retrofit (to make the API calls)
OkHttp Logging Interceptor (to debug our API requests )
Navigation Component
Glide (to load the images from the API)
