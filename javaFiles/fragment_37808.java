// position at the start of the first entry
entry = zipIn.getNextEntry();
ZipEntry firstEntry = entry;    
// size is not yet available
System.out.println("before " + firstEntry.getSize()); // prints -1

// position at the start of the second entry
entry = zipIn.getNextEntry();
// size is now available
System.out.println("after " + firstEntry.getSize()); // prints the size