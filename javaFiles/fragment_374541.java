package forum7182533;

public class NumberFormatter {

    public static String printInt(Integer value) {
        String result = String.valueOf(value);
        for(int x=0, length = 7 - result.length(); x<length; x++) {
            result = "0" + result;
        }
        return result;
    }

    public static Integer parseInt(String value) {
        return Integer.valueOf(value);
    }

}