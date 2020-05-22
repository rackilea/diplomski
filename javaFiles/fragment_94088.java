Scanner input = new Scanner(System.in);
String[] my_friend_names = new String[10];

for (int i = 0; i < my_friend_names.length; i++) {
    my_friend_names[i] = input.nextLine();

    String reversedName =  new StringBuilder(my_friend_names[i]).reverse().toString();
    System.out.println("After reverse: " + reversedName);
}