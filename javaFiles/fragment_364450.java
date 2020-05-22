public void SendGetStartedNotification(ParseUser user) {

    // initiate installation query
    ParseQuery<ParseInstallation> query  = ParseInstallation.getQuery();
    query.whereEqualTo("userId", user.getUserObject());

    // send push notification
    ParsePush push = new ParsePush();
    push.setQuery(query);
    push.setMessage(ParseUser.getCurrentUser().getUsername() + " " + "thinks you should create something!");
    push.sendInBackground();

    // send notification to NotificationsActivity
    ParseObject notification = createGetStartedMessage(view, user);
    send(notification);
}