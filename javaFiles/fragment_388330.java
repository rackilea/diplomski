public void copyFile(String fileName,String fileType, InputStream in) {

       try {


       //relativeWebPath is the path to the folder you created in your web directory
            File file = getUniqueFilename(new File(relativeWebPath+"/"+fileName));




          try ( // write the inputStream to a FileOutputStream
                  OutputStream out = new FileOutputStream(new File(relativeWebPath + "/"+file.getName()))) {
              int read = 0;
              byte[] bytes = new byte[1024];

              while ((read = in.read(bytes)) != -1) {
                  out.write(bytes, 0, read);
              }

              in.close();
              out.flush();

          }


    } catch (IOException e) {
        System.out.println(e);
    }
}

//returns a file with a unique name in case an image with the same name 
//already exist in the folder

private static File getUniqueFilename( File file )
    {
        String baseName = FilenameUtils.getBaseName( file.getName() );
        String extension = FilenameUtils.getExtension( file.getName() );
        int counter = 1;
        while(file.exists())
        {
            file = new File( file.getParent(), baseName + "-" + (counter++) + "." + extension );
        }
        return file;
    }