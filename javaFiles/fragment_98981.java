static enum Fruit { Apple, Orange, Banana };
static enum Animal { Cat, Dog, Horse };

public static final void main (String[] args) throws Exception {   
    Enum f = Fruit.Apple;
    Enum a = Animal.Cat;
    f.compareTo(a);
}