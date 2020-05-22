//Pseudo Code 
    BufferedImage bufferedImage=ImageIO.read(new File(imagePath));

   //imageDao contains the image name that i stored in the database
   String []formatSplit=imageDao.split("\\.");

   if(formatSplit.length==2){
     String format=formatSplit[1];

     //ImageUtility is class that contain code for converting bufferedimage to string
     String traineeImage=ImageUtility.encodeToString(bufferedImage,format );

     model.addAttribute("imagePath", traineeImage);
    }


    //ImageUtilty class -method

     public static String encodeToString(BufferedImage image, String type) {

        String imageString=null;
        String encodedImage=null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {

            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();


            encodedImage=org.apache.commons.codec.binary.Base64.encodeBase64String(imageBytes);

            imageString = "data:image/"+type+";base64,"+encodedImage;

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }