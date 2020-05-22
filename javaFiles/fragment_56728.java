public class FMSParser {
    public boolean isValid(String msg) {
       return msg.startsWith("$FMS");
    }

    public String[] getParams(String msg) {
       return msg.split(",");
    }
}