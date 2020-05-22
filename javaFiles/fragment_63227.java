public static void main(String[] args)
{
    Sales s1 = new Sales();

    Scanner input = new Scanner(System.in);
    System.out.print("Enter total Sales");
    s1.setTotalSales(input.nextDouble());

    System.out.print("Enter number of Items: ");
    s1.setNumOfItems(input.nextInt());

    System.out.printf("$%.2f", s1.getCommission());
    input.close();
}