URL oracle = new URL("http://www.anotherserver.com/");

HttpURLConnection connection = null;
connection = (HttpURLConnection) oracle.openConnection();
connection.setRequestMethod("POST");
connection.setDoOutput(true);
connection.setDoInput(true);

OutputStream wr = connection.getOutputStream ();

InputStream in = request.getInputStream();
byte[] buffer = new byte[512]; 
int read = in.read(buffer,0, buffer.length);
while (read >= 0) {
   wr.write(buffer,0, read);
   read = in.read(buffer,0,buffer.length);
}

wr.flush ();
wr.close ();


BufferedReader in = new BufferedReader(new InputStreamReader(
        connection.getInputStream()));
String inputLine;
while ((inputLine = in.readLine()) != null) {
    jb.append(inputLine);
}