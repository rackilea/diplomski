public static String getJSONData(Context context, String textFileName) {
    String strJSON;
    StringBuilder buf = new StringBuilder();
    InputStream json;
    try {
        json = context.getAssets().open(textFileName);

        BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));

        while ((strJSON = in.readLine()) != null) {
            buf.append(strJSON);
        }
        in.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return buf.toString();
}