public static void main(String[] args) {
    EmailNotifier en = new EmailNotifier("my.smtpserver", "sender@smtpserver");
    en.send("to@ex.com", "test subj", "test body");
    en.send("to@ex.com", "test subj", "test body");
    en.send("to@ex.com", "test subj", "test body");
}