// Send message without response handling
public void sendMessage(User user, String content) {
    user.openPrivateChannel()
        .flatMap(channel -> channel.sendMessage(content))
        .queue();
}