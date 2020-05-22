Notification notification = new Notification.Builder(context)
    // Show controls on lock screen even when user hides sensitive content.
    .setVisibility(Notification.VISIBILITY_PUBLIC)
    .setSmallIcon(R.drawable.NotIcon)
//HERE ARE YOUR BUTTONS
    .addAction(R.drawable.ic_prev, "BUTTON 1", myIntentToButtonOneScreen) // #0
    .addAction(R.drawable.ic_pause, "BUTTON 2", myIntentToButtonTwoScreen)  // #1
    .addAction(R.drawable.ic_next, "BUTTON 3", myIntentToButtonThreeScreen)     // #2
    // Apply the media style template
    .setStyle(new Notification.MediaStyle()
    .setShowActionsInCompactView(1)
    .setMediaSession(mMediaSession.getSessionToken())
    .setContentTitle("Example for you")
    .setContentText("Example for you")
    .setLargeIcon(ButtonExampleIcon)
    .build();