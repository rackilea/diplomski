package auth;

public enum UserType {
    ADMIN(Integer.MIN_VALUE),
    SYSTEM(10000),
    GENERAL(20000),
    NONE(Integer.MAX_VALUE);

    int level;

    public int getLevel() {
        return level;
    }

    private UserType(int level) {
        this.level = level;
    }
}