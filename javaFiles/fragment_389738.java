// creating global image variable for use later
Image imageVariable = new ImageIcon("image path").getImage();

public void paintComponent(Graphics g) {
   // here you could either create a Graphics2D object
   // Graphics2D g2 = (Graphics2D)g;
   // or you could use the g parameter as it is, doesn't matter.
   // use the global variable for the image to be drawn onto the screen
   // use the global value of the mouseX and mouseY for where you click the mouse
   // to place the image, and this should be it 
   g.drawImage(imageVariable, mouseX, mouseY, null);
}