if (message.startsWith("!ban")) {
        if(sender.equals(owner))
        {
            String userToBan = message.split(" ")[1];
            ban(channel, userToBan);
            sendMessage(channel, "Banned " + userToBan);
        }
        else
        {
            kick(channel, sender);
            sendMessage(channel, "You aren't my mother!");
        }
    }