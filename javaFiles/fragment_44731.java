private void uploadParts(String assetId) throws IOException {
    //set up post request
    HttpClient client = HttpClientBuilder.create().build();

    String url = "";

    //prepare video
    File video = new File("files/video.mp4");
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(video));

    int partMaxSize = 1024 * 1024 * 5;
    byte[] buffer = new byte[partMaxSize];
    double fileSize = video.length();
    System.out.println(fileSize);
    System.out.println(fileSize / partMaxSize);
    int parts = (int) Math.ceil(fileSize / partMaxSize);
    System.out.println(parts);

    for(int i = 1; i < parts+1; i++)    {
        String partNumber = i + "";
        System.out.println("part: " + partNumber);
        int partSize = (int) (i < parts ? partMaxSize : fileSize);
        fileSize -= partSize;
        int tmp = 0;
        tmp = bis.read(buffer);
        url = String.format("https://www.site.com/upload/multipart/%s/%s", assetId, partNumber);

        final HttpPut request = new HttpPut(url);
        request.addHeader("Authorization", "Bearer " + accessToken);
        request.addHeader("Content-Type", "application/octet-stream");
        request.setEntity(new ByteArrayEntity(buffer));

        //Magical code start
        int hardTimeout = 5; // seconds
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (request != null) {
                    request.abort();
                }
            }
        };
        new Timer(true).schedule(task, hardTimeout * 1000);
        //Magical code end

        HttpResponse response = client.execute(request);
        request.releaseConnection();
        System.out.println(response.getStatusLine().getReasonPhrase());
    }
    bis.close();
}