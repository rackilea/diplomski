URLConnection connection = new URL(loginUrl).openConnection();
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
connection.setDoOutput(true);
Map<String, String> formParams = new HashMap<String, String>();
formParams.put("username", "John"); // add your login Params
StringBuilder encodedParams = new StringBuilder();
for (Map.Entry<String, String> param : formParams.entrySet()) {
    encodedParams
        .append(URLEncoder.encode(param.getKey(), "UTF-8"))
        .append('=')
        .append(URLEncoder.encode(param.getValue(), "UTF-8"));
}
OutputStream outputStream = connection.getOutputStream();
outputStream.write(encodedParams.toString().getBytes("UTF-8"));

List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
String sessionCookie = null;
for (String cookie : cookies) {
    if (cookie.startsWith("JSESSIONID")) {
        sessionCookie = cookie.substring(0, cookie.indexOf(';')); // drop path, expires etc.
    }
}

// reuse cookie for next page
connection = new URL(nextUrl).openConnection();
connection.addRequestProperty("Cookie", sessionCookie);
connection.getInputStream();