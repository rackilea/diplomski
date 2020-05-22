public class GMTime {

    private String time;
    private int hour;
    private int minutes;
    private int colon;
    private String error = null;

    // **********************************************************
    // constructor passing time as a string
    public GMTime(String temp) {
        time = temp;
    }
    // end constructor
    // **********************************************************
    // method checking the colon presence and place between 1-2 index

    public void colonCheck() {
        while (time.contains(":")) {
            colon = time.indexOf(":");
            time = time.substring(colon + 1);
        } // end of while
        if (colon != 1 && colon != 2) {
            error = "Invalid separator entered";
        } else {
            error = "No error";
        }
    } // end colon check

    public String getError() {
        return error;
    }
}