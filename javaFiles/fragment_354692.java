public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);
    int value;
    double product=1;

    do
    {
        System.out.print("Value: ");
        value = in.nextInt();
        product *= value //product= product * value;
    }
    while (value>=0);

    System.out.println("Product is: "+product);
}