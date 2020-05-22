public class Guest {
    @Override
    public String toString() {
        return getGuestID() + "," + getFName() + "," +  getLName() + "," + g.getDateJoin();
    }

    // other methods...
}

public class VIPGuest extends Guest {
    @Override
    public String toString() {
        return super.toString() + ", " + getVIPstartDate() + "," + getVIPexpiryDate());

    // other methods...
}