URL restURL = new URL("http://yourdomain.com/your/rest/call");
URLConnection conn = restURL.openConnection();
InputStreamReader reader = new InputStreamReader(
               (InputStream) conn.getContent());
JsonParser parser = new JsonParser();
JsonElement root = parser.parse(reader);
MyObject = myParseFunction(root);