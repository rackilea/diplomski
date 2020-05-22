// create  & open connection 
HttpUrlConnection connection = (HttpURLConnection) new URL(adress).openConnection();

// set do output ...
connection.setDoOutput(true);

/** variable charset for encoding */
String CHARSET = "UTF-8";

// Construct the POST value/key pair  data.
String data = "login=" + URLEncoder.encode(login, CHARSET)      
        + "&password=" + URLEncoder.encode(password, CHARSET) 
        + "&remember_me=on";

byte[] dataBytes = data.getBytes(CHARSET);

// create output stram to write our creditentials 
OutputStream outputStream = new BufferedOutputStream(connection.getOutputStream());

// write value/key data to output stream
outputStream.write(dataBytes);
outputStream.flush();

// connect to url 
connection.connect();

// now we are connected and we can do other stuff get input strem header response code etc....
int responseCode = connection.getResponseCode();

 /**
 *     here we grab cookies (how?  - in other story)
 */

connection.disconnect();