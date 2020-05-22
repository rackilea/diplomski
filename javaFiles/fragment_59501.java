File tempFile = new File("<SubdirectoryIfAny/name_of_file.txt");

PrintStream write = new PrintStream(tempFile);

// specify code for your particular program so that the toString method gets the 
// info from the string array or something like that.

write.print( <objectName/this>.toStringLikeMethod() );
// remember the /n /n in the toStringLikeMethod so it prints properly in the file.