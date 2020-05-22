public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your number:");
    int num = in.nextInt();
    in.nextLine(); // so we get rid of the enter key after the number was pressed

    System.out.println("Enter name");
    String[] names = new String[num];
    for (int i = 0; i < num; i++) {
        String name = in.nextLine();
        String str1 = name.replace(new String(Character.toChars(97)), "").replace(new String(Character.toChars(101)), "")
                .replace(new String(Character.toChars(103)), "").replace(new String(Character.toChars(107)), "")
                .replace(new String(Character.toChars(107)), "").replace(new String(Character.toChars(113)), "")
                .replace(new String(Character.toChars(117)), "").replace(new String(Character.toChars(119)), "")
                .replace(new String(Character.toChars(67)), "").replace(new String(Character.toChars(71)), "")
                .replace(new String(Character.toChars(73)), "").replace(new String(Character.toChars(79)), "")
                .replace(new String(Character.toChars(81)), "").replace(new String(Character.toChars(83)), "")
                .replace(new String(Character.toChars(87)), "").replace(new String(Character.toChars(89)), "");

        names[i] = str1;

    }

    System.out.println("PRIME ASCII ARE REMOVED:");
    for (String removedName : names) {
        System.out.println(removedName);
    }
}