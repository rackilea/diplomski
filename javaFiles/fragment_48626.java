public class ReduceActor extends UntypedActor {
@Override
public void onReceive(Object message) throws Exception {
    if (message instanceof URI) {
        URI url = (URI) message;

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        asyncHttpClient.prepareGet(url.toURL().toString()).execute(new AsyncCompletionHandler<Response>() {

            @Override
            public Response onCompleted(Response response) throws Exception {
                File f = new File("e:/tmp/crawler/" + UUID.randomUUID().toString() + ".html");
                // Do something with the Response
                // ...
                // System.out.println(response1.getStatusLine());
                FileOutputStream fao = new FileOutputStream(f);
                IOUtils.copy(response.getResponseBodyAsStream(), fao);
                System.out.println("File downloaded " + f);
                getSender().tell(new WordCount(f));
                return response;
            }

            @Override
            public void onThrowable(Throwable t) {
                // Something wrong happened.
            }
        });
    } else
        unhandled(message);
}