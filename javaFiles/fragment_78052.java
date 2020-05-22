public void goforIt(){
    FTPClient con = null;

    try
    {
        con = new FTPClient();
        con.connect("192.168.2.57");

        if (con.login("Administrator", "KUjWbk"))
        {
            con.enterLocalPassiveMode(); // important!
            con.setFileType(FTP.BINARY_FILE_TYPE);
            String data = "/sdcard/vivekm4a.m4a";

            OutputStream out = new FileOutputStream(new File(data));
            boolean result = con.retrieveFile("vivekm4a.m4a", out);
            out.close();
            if (result) Log.v("download result", "succeeded");
            con.logout();
            con.disconnect();
        }
    }
    catch (Exception e)
    {
        Log.v("download result","failed");
        e.printStackTrace();
    }



}