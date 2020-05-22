int len=arr1D.length();
if(len%512 !=0))
len= len/512 +1;
else
len=len/512;

int arr2D= new int[len][512];
int k=0;
for(int i=0; i<len-1; i++)
{

 for(int j=0; j<512; j++)
 {
  arr2D[i][j]=arr1D[k];
  k++;
                if (k==arr1D.length())
                     break;
 } 
}