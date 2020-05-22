class ImageProvider{

   private static Map<String, Image> images = new HashMap<String, Image>();

   public static Image getImage(String filename){
       if(!images.contains(filename))
           try {
              images.put(filename, ImageIO.read(ImageProvider.class.getResource(filename));
           } catch (IOException ignore){
              //will return null if image cannot be loaded
           }

       return images.get(filename);
   }
}