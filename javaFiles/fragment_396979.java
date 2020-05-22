public class LeakingClass {
    private static final List<String> LEAK = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name? ");
        while (in.hasNext()) {
            name = in.next();
            System.out.println("Hi " + name);
            LEAK.add(name);
            System.out.println("What is your name? ");
        }
    }
}