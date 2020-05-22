public class Inheritance {

    public Inheritance() {
        System.out.println(this.getClass().getName());
    }

    public static void main(String[] args) {
        Testing test = new Testing();
    }

}

class Testing extends Inheritance {

    public Testing() {
        super();
    }

}