* Workaround for a bug in {@code HttpURLConnection.setRequestMethod(String)}
 * The implementation of Sun/Oracle is throwing a {@code ProtocolException}
 * when the method is other than the HTTP/1.1 default methods. So to use {@code PATCH}
 * and others, we must apply this workaround.
 *
 * See issue http://java.net/jira/browse/JERSEY-639
 */