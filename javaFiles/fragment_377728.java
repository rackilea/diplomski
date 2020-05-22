public class User {

private String username;
private String password;
private ArrayList<Double> scoreList=new ArrayList<Double>();

public User() {

}


public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String toString() {
    return username + ";" + password;
}

public String usernameString() {
    return username;
}
@Override
    public boolean equals(Object obj) {
        if (obj instanceof User){
            User tmp = (User)obj;
            return tmp.getUsername().equals(getUsername());
        }
        return false;
    }

}