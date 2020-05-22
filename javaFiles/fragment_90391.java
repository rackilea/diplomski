int target = 104978;
  int[] ara = new int[6];         

  for(int i=0;i<ara.length;i++)
  {
         ara[i]=target%10; 
         target=target/10;
  }