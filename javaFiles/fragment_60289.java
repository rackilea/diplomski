InputStreamReader str= new InputStreamReader (System.in);
BufferedReader uinp= new BufferedReader (str);
String val;
val= uinp.readLine();
while (!".".equals(val)) {
//do your stuff
//..and after done, read the next line of the user input.
val= uinp.readLine();
}