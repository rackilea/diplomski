public static void main(String[] args) {
    String line = "";
    Scanner input = new Scanner(System.in); // Notice that I moved "input" here.
    while (!line.equals("yes")) {
        System.out.println("Do you want some chocolate?");
        line = input.nextLine();
        System.out.println("You are wrong!");
    }

    System.out.println("Yup! Good answer! ^.^");
}