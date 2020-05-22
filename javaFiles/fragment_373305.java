int a[] = {28,28,28,1,10};
// int a[] = {20,20,29,29,4}; // other input of yours
// int a[] = {4,4,9,9,18};  

   int x = 26;

   int liVal = -1;
   for(int i=0; i<a.length;i++)
       if(x < a[i]) // if we met a value > x
       {
          if(liVal==-1) // if we could not find any largest value smaller than x
              liVal = a[i]; // return the value > x
          break;
       }
       else if(x > a[i]) // find the largest value smaller than x, 
       {
           if(liVal < a[i])
               liVal = a[i];
       }

System.out.println(liVal);