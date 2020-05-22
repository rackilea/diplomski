// position at the start of the first entry
entry = zipIn.getNextEntry();
// size is not yet available
System.out.println("before " + entry.getSize()); // prints -1

// read the whole entry data
while(zipIn.read() != -1);

// size is now available
System.out.println("after " + entry.getSize()); // prints the size