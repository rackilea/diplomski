public void onMessage(String channel, String sender,
                   String login, String hostname, String message) {
    if (message.equalsIgnoreCase("hi")) {
        sendMessage(channel, "Hello!");
    }
    if (message.equalsIgnoreCase("lol")) {
        sendMessage(channel, "LOL!");
    }
}