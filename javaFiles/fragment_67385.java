JSONArray ja = new JSONArray();

// Add Data to JSONArray

String s = UrlEncoder.encode(ja.toString());

// Add string to StringBuilder url

HTTPGet httpget = new HTTPGet(url.toString());