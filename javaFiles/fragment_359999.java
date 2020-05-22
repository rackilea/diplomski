import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.protocol.HttpContext;

import java.nio.CharBuffer;
import java.util.concurrent.CountDownLatch;

public class HttpAsyncTest {

    public static void main(String[] args) {
        try (CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault()) {
            httpclient.start();

            final CountDownLatch latch = new CountDownLatch(1);
            final HttpPost request = new HttpPost("https://postman-echo.com/post");
            request.setEntity(new StringEntity("This is the request data"));
            request.setHeader("Content-Type", "application/x-www-form-urlencoded");

            HttpAsyncRequestProducer producer = HttpAsyncMethods.create(request);
            AsyncCharConsumer<HttpResponse> consumer = new AsyncCharConsumer<HttpResponse>() {
                HttpResponse response;

                @Override
                protected void onResponseReceived(final HttpResponse response) {
                    this.response = response;
                }

                @Override
                protected void onCharReceived(final CharBuffer buf, final IOControl ioctrl) {
                    System.out.printf("onCharReceived: %d\n", buf.length());
                }

                @Override
                protected HttpResponse buildResult(final HttpContext context) {
                    return this.response;
                }
            };

            httpclient.execute(producer, consumer, new FutureCallback<HttpResponse>() {
                public void completed(final HttpResponse response3) {
                    latch.countDown();
                    System.out.println(request.getRequestLine() + "->" + response3.getStatusLine());
                }

                public void failed(final Exception ex) {
                    latch.countDown();
                    System.out.println(request.getRequestLine() + "->" + ex);
                }

                public void cancelled() {
                    latch.countDown();
                    System.out.println(request.getRequestLine() + " cancelled");
                }
            });

            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}