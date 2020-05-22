int a1 = 1234567;  
int a2 = a1;
int flag=0;

while(a2>0)
{
    a2/=10;               //Moves to the left by one digit
    if(a2==0)             //If there are odd no. of digits
    {
        flag=1;
        break;
    }
    a2/=10;               //Moves to the left by one digit
    a1/=10;               //Moves to the left by one digit
}
System.out.print(flag!=1?"No Mid Exists":a1%10);