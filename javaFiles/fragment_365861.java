public class SomeClass {
  Point p1;
  Point p2;

  public void actionPerformed(ActionEvent e) {

    // some code....

    int m1 = Integer.parseInt(point1.getElementsByTagName("X").item(0).getTextContent());
    int n1 = Integer.parseInt(point1.getElementsByTagName("Y").item(0).getTextContent());
    int m2 = Integer.parseInt(point2.getElementsByTagName("X").item(0).getTextContent());
    int n2 = Integer.parseInt(point2.getElementsByTagName("Y").item(0).getTextContent());

    p1 = new Point(m1, n1);
    p2 = new Point(m2, n2);
  }

  public Point getP1() {
    return p1;
  }

  public Point getP2() {
    return p2;
  }

}