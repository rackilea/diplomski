BufferedReader bufferedReader;
try {
    bufferedReader = request.getReader();
} catch (IllegalStateException e) {
    InputStream inputStream = request.getInputStream();

    // As per BalusC's comment:
    String charsetName = request.getCharacterEncoding();
    if (charsetName == null) {
        charsetName = "UTF-8";
    }

    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charsetName);
    bufferedReader = new BufferedReader(inputStreamReader);
}

bufferedReader.readLine();