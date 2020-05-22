public void sendImageRequest(String imagePath) {
    try {
        HttpClient httpClient = new DefaultHttpClient();

        File file = new File(imagePath);
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStreamReader.read(bytes);            
        ByteArrayEntity reqEntity = new ByteArrayEntity(bytes, ContentType.APPLICATION_OCTET_STREAM);
        request.setEntity(reqEntity);

        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            this.responseResult = EntityUtils.toString(entity);
        }
    } catch(Exception e) {
        System.out.println(e.getMessage());
    }   
}