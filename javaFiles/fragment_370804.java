try{
  URL imgUrl = getClass().getResource(IMAGE_PATH); // path should be a constant 
                                          // or variable, not a String literal
  if (imgUrl == null) {
    // show error and get the heck out of here
  } else {
    image = ImageIO.read(imgUrl);
  }
} catch (IOException ex){
  JOptionPane.showMessageDialog(null, "<html>Error<br>Missing images</html>" ,
       "Error",JOptionPane.ERROR_MESSAGE);
  System.exit(1);
}