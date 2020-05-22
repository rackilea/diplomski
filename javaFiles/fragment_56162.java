public class Main {
    public static void main(String[] args) {
        Main anon = new Main() {};
        System.out.println(Modifier.isFinal(anon.getClass().getModifiers())); // prints false
    }
}