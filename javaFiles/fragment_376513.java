int odd=0;
int even=0;
for(int j=1;j<c;j+=2) //Adding odd digits
{ 
    odd+=arr[j];
}
//if(c%2==1)
//c++;
for(int k=0;k<c;k+=2) //Adding even digits
{
    even+=arr[k];
}