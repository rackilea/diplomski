public static void main(String [] args)
    {
        String y = "old";
        y= func(y);
        System.out.print(y);
    }

 static String func(String x){ 
  x = "new";  
  return x
 }