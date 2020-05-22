String myWord1 = myWord+ ye[2] + ye[3] ;
System.out.println(myWord1);

String[] ary = year.split(""); // Use Regex here 
String myWord2 = myWord + ary[2] + ary[3] ;
System.out.println(myWord2);

String myWord3= myWord + year.substring(1, 3);
System.out.println(myWord3);