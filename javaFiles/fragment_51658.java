ParseQuery pushQuery = ParseInstallation.getQuery();
// Here you can personalize your pushQuery
// Add channels as you like, or remove this part to reach everyone
LinkedList<String> channels = new LinkedList<String>();
channels.add("group_1");
// Change this "message" String to change the message sent
String message = "Back4App says Hi!";
// In case you want to send data, use this
JSONObject data = new JSONObject("{\"rating\": \"5 stars\"}");

ParsePush push = new ParsePush();
// Set our Installation query
push.setQuery(pushQuery);
// Sets the channels
push.setChannels(channels);
// Sets the message
push.setMessage(message);
// Sets the data
push.setData(data);
push.sendInBackground();