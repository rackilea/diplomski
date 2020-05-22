public class Example {

    public static void main(String[] args) {

        String input = "Cat 3 4";

        Scanner sc = new Scanner(input);
        System.out.println(sc.next());

        load(sc);
    }

    static void load(Scanner sc) {

        System.out.println(sc.next());
        System.out.println(sc.next());
    }
}