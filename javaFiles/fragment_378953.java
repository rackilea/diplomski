ImageIcon icon = new ImageIcon("whatever.jpg");
 Image img = icon.getImage() ;  
 Image newImg = img.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ;  
 icon = new ImageIcon( newImg );

 ...

 classAlcBtn.setIcon(icon);