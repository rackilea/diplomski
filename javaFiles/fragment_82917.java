class  Car extends JComponent{

}

class Mazda  extends Car{

  @Override
  public void paintComponents(Graphics g) {
    g.fillOval(0, 0, this.getWidth(), this.getHeight());
    System.out.println(this.getClass());
  }
}


class Subaru extends Car{

  @Override
  public void paintComponents(Graphics g) {
    g.setColor(Color.blue);
    g.fillOval(0, 0, this.getWidth(), this.getHeight());
    System.out.println(this.getClass());
  }

}