// Gather all cookies on the first request.
URLConnection connection = new URL(url).openConnection();
List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
// ...

// Then use the same cookies on all subsequent requests.
connection = new URL(url).openConnection();
for (String cookie : cookies) {
    connection.addRequestProperty("Cookie", cookie.split(";", 2)[0]);
}
// ...