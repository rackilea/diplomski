byte buffer[] = null;
    HttpURLConnection urlConnection = null;
    try {

        urlConnection = (HttpURLConnection) urls[0].openConnection();
        urlConnection.setReadTimeout(TIMEOUT_READ);
        InputStream inputStream = urlConnection.getInputStream();

        int len = inputStream.available();
        buffer = new byte[len];

        // inputStream.read(buffer, 0, len);

        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        Log.e("Length", "" + byteBuffer.size());
        inputStream.close();
        // and then we can return your byte array.

    } catch (Exception e) {
        e.printStackTrace();

        });