# Twitch Android App
This application use REST Api to retreive information for user from twitch service.

## Configuration
Before compile app, you need:
  - create gradle.properties file (use gradle.properties.template to do that)
  - create account on Twitch and go to twitch dev to enabled developer option for you account [Twitch dev](https://dev.twitch.tv/).
  - register new App on your account [Register twitch app] (https://dev.twitch.tv/dashboard/apps). When you do that copy the client id and past to gradle.properties file
  
Now you can compile app

## Libriaries
Application used libraries:
  - [retrofit](https://github.com/square/retrofit)
  - [rx java](https://github.com/ReactiveX/RxJava)
  - [Gson](https://github.com/google/gson)
