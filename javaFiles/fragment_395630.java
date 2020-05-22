public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String invoer;
    String invoer2;
    System.out.print("Fill in your name:");
    invoer = br.readLine();
    System.out.print("Fill in your age:");
    invoer2 = br.readLine();
    try {
        for (int i = 0; i < Integer.parseInt(invoer2); i++) {
            System.out.println(invoer);
        }
    } catch (NumberFormatException e) {
        System.out.println("Age should be a number");
        e.printStackTrace();
    }
    System.out.print("" + invoer);
    System.out.print(" " + invoer2);
}