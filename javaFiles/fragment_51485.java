Runtime rt = Runtime.getRuntime();
 System.out.println("Free: " + rt.freeMemory());
  for(int i=0;i<10;i++)// To get a measurable diffrence iterate upto higher value
  {
     String str = ""+i;
     System.out.println(str);
  }
  System.out.println("Free: " + rt.freeMemory());