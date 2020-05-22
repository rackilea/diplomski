public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            in.next();
        }
        int num = in.nextInt();
        System.out.println("Thank you for choosing " + num + " today.");
    }
}