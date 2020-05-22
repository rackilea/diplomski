public boolean setdData(Context context, String filePath, String userId, String albumId, String accessToken) {
    boolean success = false;
    Bitmap bitmap = BitmapFactory.decodeFile(filePath);

    if (bitmap != null) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 87, baos);
            byte[] data = baos.toByteArray();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
            InputStreamContent content = new InputStreamContent("image/jpeg", inputStream);

            HttpRequest request = requestFactory.buildPostRequest(new genericUrl("https://picasaweb.google.com/data/feed/api/user/"+userId+"/"+albumId+"/default"), content);
            GoogleHeaders headers = new GoogleHeaders();
            String fileName = "Whatever...";
            headers.setSlugFromFileName(fileName);
            headers.setAuthorization("OAuth " + accessToken);
            request.setHeaders(headers);
            request.execute().ignore();
            // Success!
            success = true
        } catch (IOException e) {
        }
    }
    return success;
}