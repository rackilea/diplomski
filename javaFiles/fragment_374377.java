public void JSONSeparator(String JsonString) {
   try {
        JSONObject object1 = (JSONObject) new JSONTokener(jsonString.replaceAll("\\s+", "")).nextValue();
        String firstJson = object1.toString().trim();
        String nextJson = jsonString.replaceAll("\\s+", "").substring(firstJson.length());

        System.out.println("First JSON String: " + firstJson);
        System.out.println("Second JSON String: " + nextJson);
    } catch (Exception e) {
        e.printStackTrace();
    }
}