String s = 123455;
String s1 = s.substring( 0 , 1 );  // s1 = 1 
String s2 = s.substring( 1 , 3 );  // s2 = 23
String s3 = s.substring( 2 , 7 );  // s3 = 455
s1 = s1 + ',';
s2 = s2 + ',';
s = s1 + s2;   // s is a String equivalent to 1,23,455