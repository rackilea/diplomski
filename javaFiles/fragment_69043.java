public class NamedShape {
    private String name;
    private Shape shape;
    public NamedShape( String name, Shape shape ){
        this.name = name;
        this.shape = shape;
    }
    public String getName(){ return name; }
    public Shape getShape(){ return shape; }
}