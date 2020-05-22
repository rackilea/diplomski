int sum=0;
while(n>0)
{
    sum += n%10; // add the last digit
    n/=10;  // remove the last digit.
}