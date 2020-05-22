public static void main(String[] args) {
    Map<String, String> uID = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    String input = null;
    uID.put("James", "25");
    uID.put("Jack", "25");
    uID.put("John", "25");

    System.out.println("Enter your username and age");

    input = scan.nextLine();
    while (uID.containsKey(input)) {

        System.out.println("Username already exist, choose another username.");
        input = scan.nextLine();
    }

    uID.put(input, "25");
}