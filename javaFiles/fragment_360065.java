Scanner kb = new Scanner(System.in);

System.out.println("Enter height of the triangle : ");
int size = kb.nextInt();

System.out.println("Which character you want to use : ");
Character c = kb.next().charAt(0);

for (int i = 0; i < size + 1; i++)
{
    for (int j = size; j > i; j--)
    {
        System.out.print(" ");
    }
    for (int k = 0; k < (2 * i - 1); k++)
    {
        System.out.print((char) (c + Math.abs(k - i + 1)));
    }
    System.out.println();
}