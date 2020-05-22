public void testDownloadFile() throws Exception{

    URL image = new URL("http://learning.es/blog/wp-content/uploads/2014/08/java.jpg");

    File tempFile = File.createTempFile("test-", ".jpg");
    OutputStream output = new FileOutputStream(tempFile);

    try{

        IOUtils.copyLarge(image.openStream(), output);
    } finally {
        output.close();
    }

    System.out.println(tempFile.getPath());
    System.out.println(tempFile.length());
}