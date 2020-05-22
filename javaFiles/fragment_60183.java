public class Subclass {
    public Subclass() {}
    public static String print() {
        System.out.println(Subclass.class.getSimpleName());
    }

    public void main(String[] args) {
        Super.print();
        Subclass.print();
    }
}