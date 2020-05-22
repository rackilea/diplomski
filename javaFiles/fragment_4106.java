Random random= new Random();
int numbers[]= new int[10];
for (int i = 0; i < 10; i++)
{
   int number= random.nextInt(100);
   System.out.println(number);
   numbers[i]=number;
}
System.out.println(average(numbers));