URL u = null;
InputStream is = null;  

try {
    u = new URL(url);
    is = u.openStream(); 
    HttpURLConnection huc = (HttpURLConnection)u.openConnection(); //to know the size of video
    int size = huc.getContentLength();                 

    if(huc != null) {
        String fileName = "FILE.mp4";
        String storagePath = Environment.getExternalStorageDirectory().toString();
        File f = new File(storagePath,fileName);

        FileOutputStream fos = new FileOutputStream(f);
        byte[] buffer = new byte[1024];
        int len1 = 0;
        if(is != null) {
            while ((len1 = is.read(buffer)) > 0) {
                fos.write(buffer,0, len1);  
            }
        }
        if(fos != null) {
            fos.close();
        }
    }                       
} catch (MalformedURLException mue) {
    mue.printStackTrace();
} catch (IOException ioe) {
    ioe.printStackTrace();
} finally {
    try {               
        if(is != null) {
            is.close();
        }
    } catch (IOException ioe) {
        // just going to ignore this one
    }
}