@Path("async")
public class AsyncResource {

    @GET
    public ChunkedOutput<String> getChunkedStream() throws Exception {
        final ChunkedOutput<String> output = new ChunkedOutput<>(String.class);

        new Thread(() -> {
            try {
                String chunk = "Message";

                for (int i = 0; i < 10; i++) {
                    output.write(chunk + "#" + i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
            } finally {
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(AsyncResource.class.getName())
                          .log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        return output;
    }
}