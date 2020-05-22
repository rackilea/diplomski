String filename;

RandomAccessFile myFile = new RandomAccessFile(filename, "rw");

// Set write pointer to the end of the file
myFile.seek(myFile.length());

// Write to end of file here