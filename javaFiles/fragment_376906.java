public JPanelWB(String resourceName){
   try {
       // backgroundImage = ImageIO.read(new File(resourceName));
      backgroundImage = ImageIO.read(getClass().getResource(resourceName));
   } catch (IOException ex) {
       new JDialog().add(new Label("Could not open image."+ex.getMessage()));
   }
}