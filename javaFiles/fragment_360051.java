public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Please enter username: ");
    String username = null;
    try {
        username = reader.readLine();
        if ("Bob".equals(username))
            System.out.println("yes");
        else
            System.out.println("not");

        System.out.println(username.length());
        System.out.println("Bob".length());
    } catch (IOException e) {
        e.printStackTrace();
    }
}