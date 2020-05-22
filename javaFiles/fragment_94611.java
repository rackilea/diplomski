/**Method to upload file to actual path on Server*/
private String uploadFile(UploadedFile file) {

    UploadedFile myfile = file;
    String path = null;
    if (myfile == null) {

    } else {
        // All uploaded files will be stored in below path
        path = "D://FileStore//" + myfile.getFilename();
        InputStream inputStream = null;
        try {
            FileOutputStream out = new FileOutputStream(path);
            inputStream = myfile.getInputStream();
            byte[] buffer = new byte[8192];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            out.close();
        } catch (Exception ex) {
            // handle exception
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }

    }
    //Returns the path where file is stored
    return path;
}