private class UserAndActiveGame {
    private final GameObject userObj;
    private final ActiveGame game;

    public UserAndActiveGame(GameObject userObj, ActiveGame game) {
        this.userObj = userObj;
        this.game = game;
    }

    public GameObject getUserObj() {
        return userObj;
    }

    public ActiveGame getGame() {
        return game;
    }
}

private class FindSeatResult {
    private final int status;
    private final User user;
    private final ActiveGame game;

    public FindSeatResult(int status) {
        this(status, null, null);
    }

    public FindSeatResult(int status, User user, ActiveGame game) {
        this.status = status;
        this.user = user;
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public int getStatus() {
        return status;
    }

    public ActiveGame getGame() {
        return game;
    }
}