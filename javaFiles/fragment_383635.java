protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); 
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);
    try {
        detectTypeOfFile();
    } catch (IOException e) {
        System.out.println("URL: CRASH: " + e.getStackTrace());
        e.printStackTrace();
    }
}

final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
public static String bytesToHex(byte[] bytes) {
    //http://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
    char[] hexChars = new char[bytes.length * 2];
    for ( int j = 0; j < bytes.length; j++ ) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
}

public void detectTypeOfFile() throws IOException {

    String[] urls = {"http://i.imgur.com/9b4bIW9.jpg","http://i.imgur.com/f00y2uz.jpg","http://i.imgur.com/9b4bIW9.mp4","http://i.imgur.com/9b4bIW9.gif"};

    for (int i=0;i<urls.length;i++){
        URL url = new URL(urls[i]);
        HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
        connection.setRequestProperty("Range", "bytes="+0+"-"+0);
        connection.connect();
        byte[] bytes = ByteStreams.toByteArray(connection.getInputStream());
        System.out.println("URL: " + url.toString() + "  is of type: " + bytesToHex(bytes));
        switch (bytesToHex(bytes)) {
            //http://www.garykessler.net/library/file_sigs.html
            case "00":
                System.out.println("URL: " + url.toString() + "  is of type: mp4");
                break;
            case "FF":
                System.out.println("URL: " + url.toString() + "  is of type: image/jpeg");
                break;
            case "89":
                System.out.println("URL: " + url.toString() + "  is of type: image/png");
                break;
            case "47":
                System.out.println("URL: " + url.toString() + "  is of type: image/gif");
                break;
            case "49":
            case "4D":
                System.out.println("URL: " + url.toString() + "  is of type: image/tiff");
                break;
        }
        connection.disconnect();
    }
}