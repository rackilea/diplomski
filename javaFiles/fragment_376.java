for(int i=0; params[i] != null; i++)
 {
      System.out.print(params[i].getType()+ " " +params[i].getName());
      if(params[i+1] != null)
           System.out.print(", ");
 }