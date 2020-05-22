import com.ning.http.client.*;
    import java.util.concurrent.Future;

    AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    Future<Response> f = asyncHttpClient.prepareGet("http://www.ning.com/").execute(); //here you will execute async request
    Response r = f.get(); // here you will block until respons is accessible;