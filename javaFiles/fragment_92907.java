FileInputStream fis;
try {
    DefaultHttpClient client = new DefaultHttpClient();
    HttpGet request = new HttpGet(imageUrl);
    HttpResponse response = client.execute(request);
    HttpEntity entity = response.getEntity();
    int imageLength = (int)(entity.getContentLength());
    InputStream is = entity.getContent();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    byte[] b = new byte[1024];
    int bytesRead;
    while ((bytesRead = is.read(b)) != -1) {
        baos.write(b, 0, bytesRead);
    }
    data = baos.toByteArray();

    Bundle params = new Bundle();
    params.putString(Facebook.TOKEN, facebook.getAccessToken());
    params.putString("method", "photos.upload");
    params.putByteArray("picture", data);
    params.putString("caption",
            "your Caption\nYour Caption");

    String resp = facebook.request(null, params, "POST");
}