public class YourClientHttpRequestFactory extends SimpleClientHttpRequestFactory {
  @Override
   protected void prepareConnection(HttpURLConnection connection, String httpMethod) {
     connection.setRequestProperty("SecurityCookie", ssocookie.getValue());
   }
}