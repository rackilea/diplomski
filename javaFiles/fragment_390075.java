public abstract Shape {
  Color color;
  public setColor(Color c) { this.color = c}
  public abstract draw();
  ...
}
public Ellipse extends Shape ...
public Circle extends Ellipse ... /* this might be a stretch for mathemeticians */