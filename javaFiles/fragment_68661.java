int randnum = 0 ;
String fullname = "" ;// Here empty string !!!
String initials ="";
int posSpc = fullname.lastIndexOf(" "); // this is always -1
String surname = fullname.substring(posSpc+1, fullname.length()); // This is the empty string
initials = initials + fullname.charAt(0); // That throws a StringIndexOutOfBoundsException