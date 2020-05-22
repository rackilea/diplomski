public class MyClientHttpRequestFactory extends SimpleClientHttpRequestFactory {


private Cookie cookie;
//setters and getters.

@Override
protected void prepareConnection(HttpURLConnection connection, String httpMethod) {
 this.setCookie(connection.getRequestProperty("Cookie"));

}
}