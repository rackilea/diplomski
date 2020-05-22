private BlockingQueue<byte[]> messagesToSend;

public MessageSender(OutputStream _output) {
    output = _output;
    messagesToSend = new LinkedBlockingQueue<>();
}

public void run() {
    while (true) {
        try {
            sendMessage(messagesToSend.take());  // this will get blocked untill the queue is not empty
        } catch (InterruptedException e) {

        }
    }
}

public void setMessageToSend(Message message) {
    try {
        messagesToSend.put(message.getMessageHandler().getBytes()); // put new element in the queue, check if run method is blocked, wake it up
    } catch (InterruptedException e) {

    }
}