String charset = "UTF-8";
String mode = "self";
String username = "username";
String password = "bbb";
String query = String.format("%s=%s&%s=%s&%s=%s",
    URLEncoder.encode("param[mode]", charset), URLEncoder.encode(mode, charset),
    URLEncoder.encode("param[username]", charset), URLEncoder.encode(username, charset),
    URLEncoder.encode("param[password]", charset), URLEncoder.encode(password, charset));

// ... Now create URLConnection.

connection.setDoOutput(true); // Already implicitly sets method to POST.
connection.setRequestProperty("Accept-Charset", charset);
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

try (OutputStream output = connection.getOutputStream()) {
    output.write(query.getBytes(charset));
}

// ... Now read InputStream.