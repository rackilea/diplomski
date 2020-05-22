public static List<String> convertJSONtoArrayList(File f) {
    final StringBuilder jsonString = new StringBuilder(500);
    try {
        final BufferedReader reader = new BufferedReader(new FileReader(f));
        String s;
        while ((s = reader.readLine()) != null) {
            jsonString.append(s);
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
        return Collections.emptyList();
    }

    try {
        JSONArray jsonArray = new JSONArray(jsonString.toString());
        int arrayLength = jsonArray.length();
        final List<String> result = new ArrayList<String>(arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            result.add(jsonObject.getString(Tags.VALUE));
        }
        return result;
    } catch (Exception e) {
        e.printStackTrace();
        return Collections.emptyList();
    }
}