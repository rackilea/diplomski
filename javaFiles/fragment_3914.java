public static void main(String[] argh) {

    Map<String, String> phoneBook = new HashMap<String, String>();

    Scanner sc = new Scanner(System.in);
     System.out.println(" Enther the Size of Phone book : ");
    int t = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < t; i++) {
        System.out.println("Enter Name :");
        String name = sc.nextLine();
        System.out.println("Enter Phone No :");
        String phnum = sc.nextLine();

        phoneBook.put(name, phnum);

       // sc.nextLine();

    }
   System.out.println("***Search Phone Numbers (enter Name)***\n");
    while (sc.hasNext()) {

        String s = sc.nextLine();

        if (phoneBook.get(s) == null) {
            System.out.println("Not Found");
        } else {
            System.out.println(s + "=" + phoneBook.get(s));
        }
        //sc.nextLine();
    }
}