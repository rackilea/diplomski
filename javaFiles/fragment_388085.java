HttpGet get = new HttpGet(uri);

String basic_auth = new String(Base64.encodeBase64((username + ":" + password).getBytes()));
get.addHeader("Authorization", "Basic " + basic_auth);

hc.execute(get); // etc