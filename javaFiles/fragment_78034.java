public class Main {

    public static void main(String[] args) throws Exception {
        new ProcessBuilder("java", "Child").inheritIO().start().waitFor();
        System.out.println("Main exiting");
    }
}