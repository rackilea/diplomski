public class Launcher {
    public static void main(String[] args) {
        String str = "{\"pages\": {\r\n" + 
                "            \"181382\": {\r\n" + 
                "                \"pageid\": 181382,\r\n" + 
                "                \"ns\": 0,\r\n" + 
                "                \"title\": \"Anonymity\"\r\n" + 
                "            },\r\n" + 
                "            \"7181837\": {\r\n" + 
                "                \"pageid\": 7181837,\r\n" + 
                "                \"ns\": 0,\r\n" + 
                "                \"title\": \"Anonymous\"\r\n" + 
                "            }\r\n" + 
                "        }" +
                "}";


        Gson gson = new Gson();

        Wrapper results = gson.fromJson(str, Wrapper.class);

        Map<String, PageData> pages = results.getPages();

        for (PageData data : pages.values()) {
            System.out.println(data.getTitle());
        }
    }
}