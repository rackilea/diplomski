public class UploadThread implements Runnable {

   private Path file;

   public UploadThread(Path file) {
    this.file = Objects.requireNonNull(file);
   }

 @Override
  public void run() {
    try {
        String url = // api url

        URL server = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) server.openConnection();

        // setting request properties here

        connection.connect();

        try (OutputStream out = connection.getOutputStream()) {
            Files.copy(file, out);
          } finally {
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                // error handling here
            }

            connection.disconnect(); 
          }           
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}