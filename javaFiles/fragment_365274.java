public class SocialConnectionsData {
    private List<FriendWrapper> friends;

    public List<FriendWrapper> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendWrapper> friends) {
        this.friends = friends;
    }    
}

public class FriendWrapper {
    private Friend friend;

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }
}