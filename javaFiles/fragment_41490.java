try {
    InputStream inputStream = request.getInputStream();
    if (inputStream != null) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] charBuffer = new char[128];
        int bytesRead = -1;
        while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
            stringBuilder.append(charBuffer, 0, bytesRead);
        }
    } else {
        stringBuilder.append("");
    }
} catch (IOException ex) {
    throw ex;
} finally {
    if (bufferedReader != null) {
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            throw ex;
        }
    }
}

body = stringBuilder.toString();