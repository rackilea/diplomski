String ls = System.lineSeparator(); // OS dependent 'System Line Break' character(s).
int desiredStringLength = 500;      // Desired length of string to create from file contents.

/* Calculate and hold the MINIMUM number of characters 
   allowed to be in the supplied text file. A Ternary
   Operator is used to select the appropriate calculation.  */ 
int minimumFileLength = (desiredStringLength % 2 == 0 ? 
                        desiredStringLength/2 : 
                        (desiredStringLength/2) + 1);

String fileAsString = ""; // Holds all the file data as a single string.
String finalString = "";  // Will hold the string which will be built.

// Display some information...
System.out.println("Desired length of String to create from File: --> " + desiredStringLength);
System.out.println("Minimum 'Allowable' Character count in file: ---> " + minimumFileLength);

// Place the entire file contents into the fileAsString variable.
try {    
    fileAsString = new String(Files.readAllBytes(Paths.get("test2.txt")));
}
catch (IOException ex) {
    // Inform of any errors then exit method
    System.err.println("File Error! --> " + ex.getMessage());
    return;
}

// More informational display...
System.out.println("Actual character count in file: ----------------> " + fileAsString.length());
System.out.println(ls + "The Created String:");
System.out.println("===================");

// If the file contents is less the the minimum allowable then 
// Inform User and exit method.
if (fileAsString.length() < minimumFileLength) {
    System.err.println("File Content Error! The supplied file does not " +
                       "contain enough content to build a string " + desiredStringLength + 
                       " characters long!" + ls + "File content " + "total: --> " + 
                       fileAsString.length() + " characters");
    return;
}
/* If the file content count is less than the desired build 
   string length then subtract what is contained in file from 
   the desired string build size and pull the calculated amount 
   from the beginnig of file content and append it to the file 
   content. This is all placed into the finalString variable.  */
else if (fileAsString.length() <= desiredStringLength) {
    finalString += fileAsString + fileAsString.substring(0, desiredStringLength-fileAsString.length());
}
/* If the file content count is at the desired string build size
   or greater then just build the desired string from the beginning
   of the file content.       */
else {
    finalString = fileAsString.substring(0, desiredStringLength);
}

// Display the built string.
System.out.println(finalString);
// Inform User of built string length.
System.out.println(ls + "Created String Length: --> " + finalString.length());