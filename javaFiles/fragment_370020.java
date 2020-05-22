int d=0;
 int n = 55;
 do{ 
  n /= 10;
  d++;
 }while(n != 0);
 System.out.println(d);