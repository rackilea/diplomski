@EventHandler
public void playerChat(AsyncPlayerChatEvent e){
    //get the chat message
    String original = e.getMessage();

    //format the chat message with &colorCodes
    String formatted = ChatColor.translateAlternateColorCodes('&', original);

    //set the message to the formatted message
    e.setMessage(formatted);
}