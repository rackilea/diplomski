int i=0;
while(n!=0) //Digit extraction
    {          
           dig=n%10;
           n/=10;
           arr[i] = dig;
           i++;
    }
n=copy;