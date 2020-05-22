public class SessionState {
    public String[] files = new String[0];
    public String focusedFile = "";

    public String toString() {
        String result = "";
        for (String file : files) {
            result += file + ", ";
        }
        result += "selected: " + focusedFile;
        return result;
    }
}