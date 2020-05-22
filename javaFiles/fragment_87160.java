boolean boolVar1,boolVar2,boolVar3;
boolVar1 = (year % 4) == 0;
boolVar2 = (year % 100) == 0;
boolVar3 = (year % 400) == 0;
if (boolVar1 && boolVar2 && boolVar3)
{
    System.out.println("This is a leap year.");
}
else if (boolVar1 && boolVar2 && !boolVar3)
{
    System.out.println("This is not a leap year.");
}
else if (boolVar1)
{
    System.out.println("This is a leap year.");
}
else
{
    System.out.println("This is not a leap year.");
}