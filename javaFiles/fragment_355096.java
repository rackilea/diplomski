String s1 = "java";//first string
String s2 = "java";//thanks to string pool the s2 is actually using the same memory location as s1 (saving space for same value string objects)

System.out.println(s1==s2);  //true ref comparison equals thanks to string pool intervention
System.out.println(""+s1==s2); //false (the resulting string of ""+s1 is stored in a different place in memory than s4
System.out.println(""+(s1==s2));//true due to string pool
System.out.println(s1.equals(s2));  //true -> value comparison
System.out.println(s2.equals(""+s1)); //true -> value comparison


String s3 = new String("java");//this construction does not let the string pool intervene
String s4 = new String("java");//2 different memory locations for those 2 objects

System.out.println(s3==s4);  //false no string pool intervention -> 2 different memory locations
System.out.println(""+s3==s4); //false false (the resulting string of ""+s3 is stored in a different place in memory than s4
System.out.println(""+(s3==s4));//false no string pool intervention -> 2 different memory locations
System.out.println(s3.equals(s4));  //true -> value comparison
System.out.println(s4.equals(""+s3)); //true -> value comparison