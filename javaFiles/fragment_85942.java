File file = new File("D:\\binout.dat"); 
Scanner scnr = new Scanner(file);
String line = scnr.nextLine(); 
StringBuilder scb = new StringBuilder(); 
reverseString = new StringBuffer(line).reverse().toString(); 
System.out.println("Output is "+line); 
System.out.println("Reverse of string is "+reverseString.toString());