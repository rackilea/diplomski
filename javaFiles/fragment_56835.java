class Sheep implements Cloneable {

    Sheep(String name)...

    public Object clone() {
        return new Sheep(this.name); // bad, doesn't cascade up to Object
    }
}

class WoolySheep extends Sheep {

    public Object clone() {
        return super.clone();
    }
}