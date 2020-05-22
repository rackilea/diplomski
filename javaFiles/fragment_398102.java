public class Class_party {

public Class_user user1, user2;
public int numberOfPlayers;
public String id;
public ArrayList<Integer> value;
public boolean start,correct_end,accessible;

public Class_party(String id,Class_user user1, ArrayList<Integer> value, Boolean start,Boolean correct_end, Boolean accessible) {
    this.value = value;
    this.user1 = user1;
    this.numberOfPlayers = 1;
    this.id = id;
    this.start = start;
    this.accessible = accessible;
    this.correct_end = correct_end;
    user2 = null;

}


public Class_party() {
}

public Class_user getUser1() {
    return user1;
}

public void setUser1(Class_user user1) {
    this.user1 = user1;
}

public Class_user getUser2() {
    return user2;
}

public void setUser2(Class_user user2) {
    this.user2 = user2;
}

public int getNumberOfPlayers() {
    return numberOfPlayers;
}

public void setNumberOfPlayers(int numberOfPlayers) {
    this.numberOfPlayers = numberOfPlayers;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public ArrayList<Integer> getFlag() { return value; }

public void setValue(ArrayList<Integer> value) {
    this.value=value;