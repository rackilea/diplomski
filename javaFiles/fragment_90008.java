for(int i=1; i<=height; i++) {
        for (int j = 1; j <= height-i; j++) 
          System.out.print("   ");

        for(int k=1<<i-1; k>=2; k>>=1) 
          System.out.printf("%-3d",k);

        for(int l=1; l<=1<<i-1; l<<=1) 
          System.out.printf("%-3d",l);

        System.out.println();
     }