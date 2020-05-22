public class UserWithGroup {
    final Group group;
    final User user;

    public UserWithGroup(Group group, User user) {
        this.group = group;
        this.user = user;
    }
}

public class DetailWithUser {
    final Group group;
    final User user;
    final String detailName;

    public DetailWithUser(Group group, User user, String detailName) {
        this.group = group;
        this.user = user;
        this.detailName = detailName;
    }
}