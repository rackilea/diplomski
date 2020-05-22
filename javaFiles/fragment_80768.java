public class App{
    private static String url = "https://www.test.com/test";
    public static void main(String[] args) {
        JSONObject msgJson = new JSONObject();
        msgJson.put("#url#", url);
        System.out.println(getCleanURL(msgJson.toString()));
    }

    private static String getCleanURL(String url){
        return url.replaceAll("\\\\", "").trim();
    }
}