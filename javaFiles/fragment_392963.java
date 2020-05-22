String contentType = connection.getHeaderField("Content-Type");
String charset = null;

for (String param : contentType.replace(" ", "").split(";")) {
    if (param.startsWith("charset=")) {
        charset = param.split("=", 2)[1];
        break;
    }
}

if (charset != null) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(response, charset))) {
        for (String line; (line = reader.readLine()) != null;) {
            // ... System.out.println(line) ?
        }
    }
} else {
    // It's likely binary content, use InputStream/OutputStream.
}