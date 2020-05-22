System.out.println("Please enter product number or -1 when finished");
int productNo = input.nextInt();

while (productNo != -1)
{
    dailySales(productNo, employeeNo);

    System.out.println("Please enter product number or -1 when finished");
    productNo = input.nextInt();
}