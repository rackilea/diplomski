byte bin[] = new byte[255];
 int a;

 System.out.print("Enter Number: ");
 System.in.read(bin);
 Integer val= Integer.parseInt(new String(bin).trim());

  Integer temp = val; // keep val intact if you want to print it later    

  // Not temp >= 0, it'll run infinite. Also a=0, because later you are printing upto 0
  for (a = 0; temp > 0; a++) { 
      // temp % 2 returns int which doesn't support byte casting
      bin[a] = new Integer(temp % 2).byteValue();
      temp = temp / 2;
  }

  // print binary number
  System.out.print("Binary of " + val + " is = ");
  for (int i = a - 1; i >= 0; i--) {
      System.out.print(bin[i]);
  }