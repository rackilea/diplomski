private String byteToString(byte[] data) {

    String text = new String();

    for ( int i = 0; i < data.length; i++ )
        text += (char) ( data[i] & 0x00FF );
    return text;
}

private static String bytesToHexString(byte[] bytes) {   
    StringBuilder sb = new StringBuilder(bytes.length * 2);   

    Formatter formatter = new Formatter(sb);   
    for (byte b : bytes) {   
        formatter.format("%02x", b);   
    }   

    return sb.toString();   
}  


public void writeImageToServer(URL scriptURL, BufferedImage img){
 try {
        ByteArrayOutputStream jpegOutput = new ByteArrayOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(jpegOutput);

        encoder.encode(img); // imagedata are coded here

        HttpURLConnection urlConnection = (HttpURLConnection)
        scriptURL.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);

        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");

        byte[] imageData = jpegOutput.toByteArray();

        //String imageString = byteToString(imageData);     // if you want a string
        String imageString = bytesToHexString(imageData);   // if you want hex string
        String content = "img=" + URLEncoder.encode (imageString,"UTF-8");

        urlConnection.setRequestProperty("Content-length", String.valueOf(content.length()));

        OutputStream urlout = urlConnection.getOutputStream();

        DataOutputStream printOut = new DataOutputStream(urlout);
        printOut.writeBytes(content); // writing data to the serverscript

        urlout.flush();
        urlout.close();
        printOut.flush();
        printOut.close();
        jpegOutput.flush();
        jpegOutput.close();

        urlConnection.disconnect();

        //System.err.println("Serverresponse: "+ urlConnection.getResponseMessage());

        // this works in firefox
        //try { getAppletContext().showDocument (new URL("javascript:msg(\""+ urlConnection.getResponseMessage() + "\")")); } catch (MalformedURLException me) { }

    }
    catch( IOException e ){ e.printStackTrace(); }
}