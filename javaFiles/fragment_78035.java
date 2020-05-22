public class Child {

    public static void main(String[] args) throws Exception {
        new ProcessBuilder("java", "GrandChild").inheritIO().start().waitFor();
        System.out.println("Child exiting...");
    }

}