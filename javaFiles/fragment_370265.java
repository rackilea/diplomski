class SuperClass{
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

class StaticObject extends SuperClass{

    StaticObject(int position){
        setPosition(position);
    }

}

class DynamicObject extends SuperClass{

    DynamicObject(int position){
        setPosition(position);
    }
}

public class Constraint<T1 extends SuperClass, T2 extends SuperClass> {

    private T1 object1;
    private T2 object2;


    public Constraint(T1 object1, T2 object2) {

        this.object1 = object1;
        this.object2 = object2;
    }

    public void update() {

        object2.setPosition(object1.getPosition());
    }

    public static void main(String[] args) {
        Constraint<StaticObject, DynamicObject> c = new Constraint<StaticObject, DynamicObject>(new StaticObject(2), new DynamicObject(5));
        c.update();
    }

}