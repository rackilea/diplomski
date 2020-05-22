public void delete(Message message) {
    if (message instanceof Email) {
        deleteEmail(Email) message);
    }
    else if (message instanceof Sms) {
        deleteSms((Sms) message);
    }
}