public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String line;
    do {
        System.out.println("Do you want some chocolate?");
        line = input.nextLine();
        System.out.println("You are wrong!");
    } while (!line.equals("yes"));

    System.out.println("Yup! Good answer! ^.^");
}