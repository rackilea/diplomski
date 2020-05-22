public class Circle {
  private double rad;

  public void setRad(double rad) {
    this.rad = rad;
  }

  public double getCircumference() {
    return rad * 2 * Math.PI;
  }
}