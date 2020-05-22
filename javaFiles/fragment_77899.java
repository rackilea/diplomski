URL url = new URL("http://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver%20BC%7CSeattle&destinations=San%20Francisco%7CVictoria%20BC&mode=bicycling&language=fr-FR&sensor=false");
ReadableByteChannel inputChannel;
WritableByteChannel outputChannel;
try {
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    InputStream urlStream = connection.getInputStream();

    File outputFile = new File("/path/to/output/file");
    inputChannel = Channels.newChannel(urlStream);
    outputChannel = (new FileOutputStream(outputFile)).getChannel();

    outputChannel.transferFrom(inputChannel, 0, connection.getContentLength());
} catch (IOException ioe) {
  // handle your exception here
} finally {
    //check for nulls and stuff before you do this
    inputChannel.close();
    outputChannel.close();
}