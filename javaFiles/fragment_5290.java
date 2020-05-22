public class Chairing {
    private int numbers;
    List<Chairset> myList = new ArrayList<Chairset>();
    public void someMethod() {
        myList.add(5,new Chairset("10"));
    }
}

public class Chair extends Chairset {
    int price;

    public Chair(int price, Chairset c){
        super(c.getInfo());
        this.price = price;
    }
}

public class Chairset {
    String info;

    public Chairset(String id){
        id = info;
    }
}