new Thread() {
    @Override
    public void run() {
        sendNotificationMail(emailId);
    }
}.start();