public static void main (String[] args)

{
    Scanner input = new Scanner(System.in);
    String[] my_friend_names = new String[];

    for (int i = 0; i < my_friend_names.length; i++)
    {
        my_friend_names[i] = input.nextLine();
    }
    for(int i = 0; i < my_friend_names.length; i++)
    {
        System.out.println("Name: " + my_friend_names[i]);
    }
}