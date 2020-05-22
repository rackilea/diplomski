public enum ImageEnum {

   A(0 , "a.png" , "foo" , true),
   B(1 , "b.png" , "" , true);

   private final BufferedImage image;

   private ImageEnum(.., String filename, ..) {
        // first assign to tempImage to meet teh final modifier of image
        BufferedImage tempImage = null;
        try {
             tempImage = ImageIO.read(new File(filename));
        } catch (Exception e) {
             tempImage = null;
        }
        image = tempImage;
   }

}