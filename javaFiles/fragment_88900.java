public interface IShape {
    String getName();
}

public class Square implements IShape {
    private String name = "Square";
    @Override
    public String getName() {
        return name;
    }
}

public class Circle implements IShape {
    private String name = "Circle";
    @Override
    public String getName() {
        return name;
    }
}

public static void main(String[] args){
    List<IShape> list = new ArrayList<>();
    list.add(new Square());
    list.add(new Circle());
    list.add(new Circle());
    list.add(new Square());
    list.add(new IShape() {
        @Override
        public String getName() {
            return "Triangle";
        }
    });

    for(IShape test : list){
        System.out.println(test.getName());
    }
}