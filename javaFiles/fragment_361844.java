public static File mergeImages(List<File> files, String argID, String fileType, String compressionType) throws Exception{

    //find the temp location of the image
    String location = ConfigManager.getInstance().getTempFileDirectory();
    logger_.debug("image file type [" + fileType + "]");
    ImageReader reader = ImageIO.getImageReadersByFormatName(fileType).next();
    ImageWriter writer = ImageIO.getImageWritersByFormatName(fileType).next();
    //set up the new image name
    String filePath = location + "\\" + argID +"." + fileType;
    //keeps track of the images we copied from
    StringBuilder builder = new StringBuilder();
    List<IIOImage> bufferedImages = new ArrayList<IIOImage>();
    IIOMetadata metaData = null;
    for (File imageFile:files) {

        //get the name for logging later
        builder.append(imageFile.getCanonicalPath()).append("\n");
        if (metaData == null){
            reader.setInput(ImageIO.createImageInputStream(imageFile));
            metaData = reader.getStreamMetadata();

        }

        BufferedImage image = ImageIO.read(imageFile);
        bufferedImages.add(new IIOImage(image, null, null));
    }


    ImageWriteParam params = writer.getDefaultWriteParam();
    if (compressionType != null){
        params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        params.setCompressionType(compressionType);
    }

    ImageOutputStream outStream = null;

    try{
        outStream = ImageIO.createImageOutputStream(new File(filePath));
        int numPages = 0;
        writer.setOutput(outStream);
        for(IIOImage image:bufferedImages){
            if (numPages == 0){
                writer.write(metaData, image, params);
            }
            else{
                writer.writeInsert(numPages, image, params);
            }
            numPages++;
        }
    }
    finally{
        if (outStream != null){
            outStream.close();
        }

    }

    //set up the file for us to use later
    File mergedFile = new File(filePath);

    logger_.info("Merged image into [" + filePath + "]");
    logger_.debug("Merged images [\n" + builder.toString() + "] into --> " + filePath);

    return mergedFile;

}