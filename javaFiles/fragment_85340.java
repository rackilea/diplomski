static boolean check(int n)
   {
           if(n<30)
           {
              return n==2 || n==3 || n==5 || n==7 || ...
           }

           for(int i = 30; i * i <= n; i += 30)
           {
              if (n % (i + 1))==0 return false;
              if (n % (i + 7))==0 return false;
              if (n % (i + 11))==0 return false;
              if (n % (i + 13))==0 return false;
              if (n % (i + 17))==0 return false;
              if (n % (i + 19))==0 return false;
              if (n % (i + 23))==0 return false;
              if (n % (i + 29))==0 return false;
           }
           return true;
   }