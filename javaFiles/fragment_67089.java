public class TempInfo {

private TempInfo() {
}

static TempInfo tempInfo;
private static int user_ID;

public static TempInfo getInstance() {
    if (tempInfo == null) {
        tempInfo = new TempInfo();
    }
    return tempInfo;
}

public int getID() {
    return user_ID;
}

public void setID(int id) {
    this.user_ID = id;
}