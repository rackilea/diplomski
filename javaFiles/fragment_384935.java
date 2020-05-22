static void honoi(char x,char y,char z,int n)
  {
      for (long i = 1; i < Math.pow(2,n); ++i)
      {
         switch((int)i%2)
          {
             case 0:System.out.println("STEP "+i+" :\tMove disk "+(long)disk_no(i,n)+" from pole "+z+" to "+y);
                 break;
             default:System.out.println("STEP "+i+" :\tMove disk "+(long)disk_no(i,n)+" from pole "+x+" to "+y);
                 char temp = x;
                 x = y;
                 y = z;
                 z = temp;
          }
      }
  }