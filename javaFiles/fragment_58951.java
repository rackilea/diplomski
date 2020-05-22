public static void displayStatistics(int k)
    {
        if(k>=1 && k<=200) 
      {
        int low,high;
        if(k%10==0)
        {
            low=k-9;
            high=k;
        }
        else 
        {
            low=k-k%10+1;
            high=k-k%10+10;
        }
        System.out.println("value in range " +low+" -"+high); 

      } else {
      System.out.println("Integer not in range of 1-200");
      }
    }