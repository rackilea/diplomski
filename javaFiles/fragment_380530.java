class UserRequest implements Runnable {

    private final int userId;

    public UserRequest(int userId) {
        this.userId = userId;
    }

    public void run() {
        // process the request
    }

    public int getUserId() {
        return userId;
    }
}