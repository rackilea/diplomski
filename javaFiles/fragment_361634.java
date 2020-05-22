public static void main(String args[])
{
    System.out.println("Choissiez un nombre entier postif");

    Scanner input = new Scanner(System.in);
    int how_many = input.nextInt();

    for(int i = 1; i <= how_many; i++)
        System.out.println(String.format("%0" + i + "d", 0).replace("0", "*"));

    input.close();
}