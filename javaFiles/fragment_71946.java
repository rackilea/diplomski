// your first request that does the authentication
URL authUrl = new URL("https://example.com/authentication");
HttpsURLConnection authCon = (HttpsURLConnection) authUrl.openConnection();
authCon.connect();

// temporary to build request cookie header
StringBuilder sb = new StringBuilder();

// find the cookies in the response header from the first request
List<String> cookies = authCon.getHeaderFields().get("Set-Cookie");
if (cookies != null) {
    for (String cookie : cookies) {
        if (sb.length() > 0) {
            sb.append("; ");
        }

        // only want the first part of the cookie header that has the value
        String value = cookie.split(";")[0];
        sb.append(value);
    }
}

// build request cookie header to send on all subsequent requests
String cookieHeader = sb.toString();

// with the cookie header your session should be preserved
URL regUrl = new URL("https://example.com/register");
HttpsURLConnection regCon = (HttpsURLConnection) regUrl.openConnection();
regCon.setRequestProperty("Cookie", cookieHeader);
regCon.connect();