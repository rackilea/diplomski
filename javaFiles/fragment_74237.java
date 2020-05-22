// Get tracker.
Tracker t = ((MyApplicationClass)
getActivity().getApplication()).getTracker(MyApplicationClass.TrackerName.APP_TRACKER);

// Set screen name. Where path is a String representing the screen name.
t.setScreenName("YOUR_CUSTOM_LABLE_FOR_THIS_SCREEN");

// Send a screen view.
t.send(new HitBuilders.AppViewBuilder().build());