class Application {
    private IApplicatioNMail mail;

    public Application(IApplicationMail mail) {
        this.mail = mail;
    }

    public run(String[] receiverList, String message, String body) {
        for (String receiver : receiverList) {
           mail.sendMessage(receiver, message, body);
        }
    }
}

class JavaApplicationMail implement IApplicationMail {
    public sendMessage(String receiver, String message, String body) {
        JavaMail.sendMessage(receiver, message, body);
    }
}