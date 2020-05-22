try {
    Image img= ImageIO.read(Main.class.getClassLoader().getResourceAsStream("pepsi.jpg"));
    System.out.println(img.getWidth(null));  //this is just a test, when it prints out the width of your image, you have the right file loaded 
} catch (IOException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
}