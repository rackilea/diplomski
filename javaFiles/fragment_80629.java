// load your data...

InputStream is = ...;

BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);

StringBuilder sb = new StringBuilder();
String line = null;

while ((line = reader.readLine()) != null) {
    sb.append(line + "\n");
}

if (is != null)
    is.close();

String result = sb.toString();