Scanner keysIn = new Scanner(System.in);
System.out.print("Please enter your number: ");

long originalNum = keysIn.nextLong(2);  // specify radix of 2
System.out.println(Long.toBinaryString(~originalNum));  // print binary string

keysIn.close();