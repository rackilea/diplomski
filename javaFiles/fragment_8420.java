conf = new Configurar(this, true,control);           
conf.setVisible(true); // Some kind of file chooser ??
File newIcon =new File(logo);
if (newIcon.exists()) {
   ImageIcon img = new ImageIcon(newIcon.getAbsolutePath()); 
   btn_main_image.setIcon(img);
   //this.update(btn_main_image.getGraphics()); // WHAT IS THIS?!?!?!
   //btn_main_image.updateUI(); // NO NO NO, this has nothing to do with refreshing the graphics, it's L&F stuff
   btn_main_image.invalidate();
   // Use this ONLY if invalidate doesn't work...
   btn_main_image.revalidate();
   btn_main_image.repaint();
}