//an interface that will let your server work with its listeners
interface MessageListener {
    public void messageSent();
}


class Server {
    List<MessageListener> listeners = new ArrayList<MessageListener>();

    //method to register listeners to be notified of incoming messages
    public void addListener(MessageListener toAdd) {
        listeners.add(toAdd);
    }

    public void sendMessage() {
        //code your logic here
        System.out.println("Message sent");

        // Notify everybody that may be interested.
        for (MessageListener hl : listeners)
            hl.messageSent();
    }

}

class GuiImplementation implements MessageListener {
    @Override
    public void messageSent() {
         System.out.println(message);
    }
}