BufferedImage img = null;
try {
     img = ImageIO.read(new File("D:\\logo.jpg"));
} catch (IOException e) {
      System.out.println("Exception is --- "+ e.getMessage());
      e.printStackTrace();
}