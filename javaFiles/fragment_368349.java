class Painter extends Canvas{
    Image image;
    private URL url;
    public void setImage(String file) {
        image = Toolkit.getDefaultToolkit().getImage(file);
        repaint();
    }
    public void paint(Graphics g) {
      if(image!=null) {
        double d = image.getHeight(this) / this.getHeight();
        double w = image.getWidth(this) / d;
        double x = this.getWidth() / 2 - w / 2;
        g.drawImage(image, (int) x, 0, (int) (w), this.getHeight(), this);
      }
    }
}