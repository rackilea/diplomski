interface Handler {

    void handle();
}

class LoginHandler implements Handler {

    public void handle() {
        System.out.println("HANDLER CALLED!");
    }
}