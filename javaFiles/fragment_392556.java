int result[] = new int[count];
int copyIndex = 0;
for (index = 0; index < a.length; index++) 
{
     if( a[index] == target )
     {
          result[copyIndex] = index ;
          ++copyIndex;  

          if( copyIndex == count )
              return result ;              
     }  
}