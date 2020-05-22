public abstract class ObjectType {
    public int objectWidth;
    public ObjectType () {}
}

public abstract class Box extends ObjectType {
    public Box () {
        objectWidth = 50;
    }
}