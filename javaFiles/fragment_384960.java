class Twodarray
{
 public static void main(String []args)
 {
  char a[][]={{'a','b'}, {'b','a'}};
  char b[][]={{'a','b','c'}, {'b','a','d'}, {'a','b','a'}, {'a','b','b'}, {'a','b','a'}, {'b','a','a'}};
  int c=number_of_2d_arrays(b,a);
  System.out.println(c);
 }
  public static int number_of_2d_arrays(char [][]arr1,char [][]arr2)
    {
     int i=0,j=0,c=0;
     while(true)
     {
      int row=i,col=j;      
      if(arr2.length>arr1.length-row)
      {
       break;
      }
      else if(arr2[0].length>arr1[0].length-col&&col==0)
      {break;}
      else if(arr2[0].length>arr1[0].length-col)
      {++i;j=0;}
      else
      {
       boolean matches=true;
       for(int a=0;a<arr2.length;++a)
       {col=j;
        for(int b=0;b<arr2[0].length;++b)
        {         
         if(arr1[row][col++]!=arr2[a][b])
         {matches=false;break;}
        }    

        if(!matches)
         break;
        ++row;
       }       
       if(matches)
        {++c;}
       ++j;
      }
     }
    return c;
    }
}