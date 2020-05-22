URL url = new URL(urlString);
HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

con.setDoOutput(true);
con.setRequestMethod("POST");
con.addRequestProperty("Authorization", getAuthToken());
con.addRequestProperty("Content-Type", "application/vnd.oracle.adf.resourceitem+json;charset=utf-8");

String input = String.format("{\"%s\":\"%s\",\"%s\":\"%s\"}", field, value, field2, value2);

System.out.println(input);
OutputStream outputStream = con.getOutputStream();
outputStream.write(input.getBytes());
outputStream.flush();

con.connect();
System.out.println(con.getResponseCode());
// Uncompressing gzip content encoding
GZIPInputStream gzip = new GZIPInputStream(con.getInputStream());

StringBuffer szBuffer = new StringBuffer();

byte tByte[] = new byte[1024];

while (true) {
    int iLength = gzip.read(tByte, 0, 1024);

    if (iLength < 0) {
        break;
    }

    szBuffer.append(new String(tByte, 0, iLength));
}
con.disconnect();

returnString = szBuffer.toString();