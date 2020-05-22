private static int FIRST_ELEMENT = 0;

public static void main(String[] args) {
    JSONArray json = new JSONArray("[{\"Hello1\":\"1\"},{\"Hello2\":\"2\"}]");

    if (json.length() > 0) {
        System.out.println("First: " + json.getJSONObject(FIRST_ELEMENT).toString());// parse the date instead of toString()
    }
}