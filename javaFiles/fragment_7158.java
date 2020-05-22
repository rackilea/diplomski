for (String imageUrl : imagesUrls) {
    Request request = new Request.Builder().url(imageUrl).build();
    Response response = client.newCall(request).execute();
    File downloadedLogo = new File("C:\\selenium_work\\ScrappingText.PDF\\image\\" + imageUrl.substring(imageUrl.lastIndexOf('/') + 1));
    BufferedSink sink = Okio.buffer(Okio.sink(downloadedLogo));
    sink.writeAll(Objects.requireNonNull(response.body()).source());
    sink.close();
}