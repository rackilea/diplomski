final JLabel imageLabel = new JLabel("", image, JLabel.CENTER);
......
final ActionListener updater = new ActionListener() {

   public void actionPerformed(ActionEvent e) {
      ImageIcon image = new ImageIcon("/Users/computerscience2/Desktop/image-slider-5.jpg");
      imageLabel.setIcon(image);
      imageLabel.updateUI(); //Tell to your frame he needs to redraw the image
   }
};