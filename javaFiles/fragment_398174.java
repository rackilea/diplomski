try {
    //URL u  = new URL("https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/term/10_hiddingh_weekwkndph.pdf");
    URL u  = new URL("https://www.uct.ac.za/downloads/uct.ac.za/currentstud/services/jammie/vac/10_hiddingh.pdf");

    HttpsURLConnection connection;

    connection = (HttpsURLConnection)u.openConnection();
    BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    int byte_read = is.read();
    while(byte_read != -1)
    {
        bos.write(byte_read);
        byte_read = is.read();
    }

    byte[] bos_data = bos.toByteArray();
    System.out.println("buffer data length " + bos_data.length);
    } catch (IOException e) {
        e.printStackTrace();
    }