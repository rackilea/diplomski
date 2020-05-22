Object [] a = new Object[2];
a[0] = "blue";
a[1] = "red";
String [] b = (String []) a; // a and b now refer to the same array; this does NOT work!!
a[0] = new Date(); 
// What's b[0] now?