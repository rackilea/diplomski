public String loadJSONFromAsset() {
    StringBuilder stringBuilder = new StringBuilder();
    try { 
        InputStream is = getAssets().open("animals.json");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        } 

        bufferedReader.close();
        return stringBuilder.toString();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null; 
}