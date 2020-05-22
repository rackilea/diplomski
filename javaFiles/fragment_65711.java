class Shape{
    int id=1;
    void base(){
        System.out.println("Shape.base()");
    }
}

// unrelated class, but same func name
class OtherShape extends Shape{
    float id=1.1f;
    @Override
    void base(){
        System.out.println("OtherShape.base()");
    }
}

public class Main {

    static <T extends Shape> void testShape(T shape){
        shape.base();
    }
    ...
}