public class PutTest {

    private static final String account = <your account name>;
    private static final String key = <your account key>;

    public static void main(String args[]) throws Exception {

        File file = new File(<your file path>);
        FileInputStream inputStream = new FileInputStream(<your file path>);

        String urlString = "https://" + account + ".blob.core.windows.net/<your container>/<your file name e.g:test.txt>";
        HttpURLConnection connection = (HttpURLConnection) (new URL(urlString)).openConnection();
        getFileRequest(connection, account, key,  file.length());
        // connection.connect();
        connection.setDoInput(true);
        connection.setDoOutput(true);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        OutputStream out = connection.getOutputStream();
        out.write(buffer);
        out.flush();
        out.close();
        System.out.println("Response message : " + connection.getResponseMessage());
        System.out.println("Response code : " + connection.getResponseCode());

        BufferedReader br = null;
        if (connection.getResponseCode() != 200) {
            br = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
        } else {
            br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
        }
        System.out.println("Response body : " + br.readLine());
    }

    public static void getFileRequest(HttpURLConnection request, String account, String key, long length)
            throws Exception {
        SimpleDateFormat fmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = fmt.format(Calendar.getInstance().getTime()) + " GMT";
        String stringToSign = "PUT\n" + "\n" // content encoding
                + "\n" // content language
                +length+"\n"// content length
                + "\n" // content md5
                +"\n" // content type
                + "\n" // date
                + "\n" // if modified since
                + "\n" // if match
                + "\n" // if none match
                + "\n" // if unmodified since
                + "\n" // range
                + "x-ms-blob-type:BlockBlob" + "\n" 
                + "x-ms-date:" + date + "\n"
                + "x-ms-version:2015-02-21"+"\n" // headers
                + "/" + account + request.getURL().getPath(); // resources
        System.out.println("stringToSign : " + stringToSign);
        String auth = getAuthenticationString(stringToSign);
        request.setRequestMethod("PUT");

        request.setRequestProperty("x-ms-blob-type", "BlockBlob");
        request.setRequestProperty("x-ms-date", date);
        request.setRequestProperty("x-ms-version", "2015-02-21");
        request.setRequestProperty("Authorization", auth);
        request.setRequestProperty("Content-Length", String.valueOf(length));

    }

    private static String getAuthenticationString(String stringToSign) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(Base64.decode(key), "HmacSHA256"));
        String authKey = new String(Base64.encode(mac.doFinal(stringToSign.getBytes("UTF-8"))));
        String auth = "SharedKey " + account + ":" + authKey;
        return auth;
    }
}