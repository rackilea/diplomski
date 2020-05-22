class Application {
    public run(String[] receiverList, String message, String body) {
        for (String receiver : receiverList) {
           JavaMail.sendMessage(receiver, message, body);
        }
    }
}