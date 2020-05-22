private void sendMessage(Message message) {
    try {
       this.conOutputStream.reset();
       this.conOutputStream.writeObject(message);
       this.conOutputStream.flush();
    } catch (IOException ex) {
            ......
    }
}