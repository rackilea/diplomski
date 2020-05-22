public class Playground {

    public static void main(String[] args) {
        String testInput = "http://abc-xyz.com/AppName/service?id=1234&isStudent&stream&shouldUpdateRecord=Y&courseType";

        String[] tokens = testInput.split("\\?");
        String   urlPrefix = tokens[0];
        String   paramString = tokens[1];

        String[] params = paramString.split("&");

        StringBuilder sb = new StringBuilder();
        sb.append(urlPrefix + "?");
        String keyValueRegex = "(\\w+)=(\\w+)";
        String amp = "";    // first time special
        for (String param : params) {
            if (param.matches(keyValueRegex)) {
                sb.append(amp + param);
                amp = "&";  // second time and onwards
            }
        }

        System.out.println(sb.toString());

    }

}