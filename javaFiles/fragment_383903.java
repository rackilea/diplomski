private static String convertInputStreamToString(InputStream inputStream) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    String line = "";
    String result3 = "";
    while ((line = bufferedReader.readLine()) != null)
        result3 += line;

    inputStream.close();
    return result3;
}