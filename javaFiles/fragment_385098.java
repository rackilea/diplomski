File parentDir = outputFile.getParentFile();
 if(parentDir !=null && ! parentDir.exists() ){
    if(!parentDir.mkdirs()){
        throw new IOException("error creating directories");
    }
 }
 ImageIO.write(image, "png", outputFile);