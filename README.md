[![Build Status](https://img.shields.io/badge/platform-Android-green)](https://www.android.com/) [![API](https://img.shields.io/badge/API-+23-brightgreen)](https://android-arsenal.com/api?level=23) [![API](https://img.shields.io/badge/license-MIT-blue)]()

<img src="https://i.ibb.co/WtCKy6j/ic-launcher-web1.png" width="80" height="80" align="center">

# Content
- [About Projects](https://github.com/studiodoctor/weather-app#about-projects)
  - [Screenshots](https://github.com/studiodoctor/weather-app#screenshots)
  - [Abstract](https://github.com/studiodoctor/weather-app#abstract)
  - [Project Details](https://github.com/studiodoctor/weather-app#projects-details)
  - [Library and Tools](https://github.com/studiodoctor/weather-app#library-and-tools)
  - [How Can I Use](https://github.com/studiodoctor/weather-app#how-can-i-use)
- [Architecture](https://github.com/studiodoctor/weather-app#architecture)
- [Design](https://github.com/studiodoctor/weather-app#desing)
- [Support](https://github.com/studiodoctor/weather-app#support)
- [Contact](https://github.com/studiodoctor/weather-app#contact)
- [License](https://github.com/studiodoctor/weather-app#license)

# Download from Google PlayStore
<p align="start">
<a href="https://play.google.com/store/apps/details?id=com.distech.weather">
         <img alt="Qries" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Google_Play_Store_badge_EN.svg/800px-Google_Play_Store_badge_EN.svg.png"
         width="200" height="60">
</a>
</p>

# About Project
### Screenshots
<img src="https://i.ibb.co/JjbMSF7/ss1.jpg" width="156" height="275">    <img src="https://i.ibb.co/Y8JtHtZ/ss2.jpg" width="156" height="275">    <img src="https://i.ibb.co/HTD15QL/ss3.jpg" width="156" height="275">    <img src="https://i.ibb.co/xCz7W5J/ss4.jpg" width="156" height="275">    <img src="https://i.ibb.co/P6CM7sC/ss5.jpg" width="156" height="275">

### Project Details
In this weather application construction, I developed using the APIs offered on Rapid Api's OpenWeatherMap, when we log in to the application, we first encounter location permission transactions. When the permit processes are positive, we come to the home page first. Information from the location and weather details are shown to us. When we click the daily weather from the Bottom Bar menu options, the 15-day and 3-hour weather data of our location is available. When we click the other option, the weather information of the nearest cities in our location is available. There is a background feature that changes depending on the day and night situation in your location.

### How Can I Use
If you want to use this project, all you have to do is 
```
/api/RequestInterceptor/
"x-rapidapi-key" = "Your API KEY"
```
you can follow this path and use the API you obtained from Rapid Api's OpenWeatherMap.

### Libraries and tools
 - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
 - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
 - [DataBinding](https://developer.android.com/topic/libraries/data-binding/)
 - [Navigation](https://developer.android.com/guide/navigation/)
 - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
 - [RxJava](https://github.com/ReactiveX/RxJava)
 - [Retrofit](https://square.github.io/retrofit/)
 - [OkHttp](https://square.github.io/okhttp/)
 - [SimpleLocation](https://github.com/delight-im/Android-SimpleLocation)
 - [Glide](https://github.com/bumptech/glide)

# Architecture
 - [MVVM](https://developer.android.com/jetpack/docs/guide)

# Design
I tried to make the design as good as I could for me :) I tried to be inspired by [Freepik](https://www.freepik.com/) and [Flaticon](https://www.flaticon.com/) sites.

# License
```
Copyright (c) 2020 

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
