String subject = "Ed Sheeran";
URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&format=json&exsentences=1&exintro=&explaintext=&exsectionformat=plain&titles=" + subject.replace(" ", "%20"));
String text = "";
try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
    String line = null;
    while (null != (line = br.readLine())) {
        line = line.trim();
        if (true) {
            text += line;
        }
    }
}

System.out.println("text = " + text);
JSONObject json = new JSONObject(text);
JSONObject query = json.getJSONObject("query");
JSONObject pages = query.getJSONObject("pages");
for(String key: pages.keySet()) {
    System.out.println("key = " + key);
    JSONObject page = pages.getJSONObject(key);
    String extract = page.getString("extract");
    System.out.println("extract = " + extract);
}