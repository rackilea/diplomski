public void changePic() {
    JOptionPane.showMessageDialog(null, "change pic reached for " + this.name);
    BufferedImage myPic2 = null;
    try {
        myPic2 = ImageIO.read(new File(pic2));
    } catch (IOException ex) {
        System.out.println("error in image upload");
    }
    label.setIcon(new ImageIcon(pic2));
}