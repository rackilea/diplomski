FileOutputStream fos = null;
try {
    fos = new FileOutputStream("myfilename");
    fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8")); //write XML header, as XStream doesn't do that for us
    byte[] bytes = xml.getBytes("UTF-8");
    fos.write(bytes);

} catch(Exception e) {
    e.printStackTrace(); // this obviously needs to be refined.
} finally {
    if(fos!=null) {
        try{ 
            fos.close();
        } catch (IOException e) {
            e.printStackTrace(); // this obviously needs to be refined.
        }
    }
}