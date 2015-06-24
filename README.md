# Yet Another MVP (YAMVP) #

A derivative of the [Model-View-Presenter](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter)
pattern that aims to modularize your code and provide Fragment utility classes. This library focuses on the
use of single-activity-multiple-fragment approach.

This library makes use of the following core classes:

### View ###
Implemented by a Fragment, declares manipulation methods for the screen and its components.
Views shouldn't have any business logic in it. It should only focus on making screen adjustments and on its components;
having methods that are called by its Presenter. All Views must have an instance of a Presenter.

### Presenter ###
The bridge between the View and business logic classes, the Presenter manages the events for the View's
components and its lifecycle activities.

### ScreenController ###
Provides methods for easy control of the Fragments; from adding, stacking, and removal of screens.
All Views must have an access on this.

## How to use the library ##

Simply add the following dependency to your build.gradle file:

    compile 'com.noobs2d.android:yamvp:0.0.1'

## Sample project ##

A sample project is available [here]() with an APK available on [Google Playstore]().