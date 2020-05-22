Scanner input = new Scanner (System.in); 
int number= input.nextInt();
boolean prime;
for (int i=1;i<=number;i++)
{
prime=true;
for(int j=2;j<=i/2;j++)
{
if(i%j==0)
{
prime=false;
break;
}
}
if(prime)
{
System.out.println(i+",");
}
}