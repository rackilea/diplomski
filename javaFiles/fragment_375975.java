RandomAccessFile f = new RandomAccessFile("/my/image/file", "rw");

// read some data.

long positionToJump = 10L;

long origPos = f.getFilePointer(); // store the original position

f.seek(positionToJump);
// now you are at position 10, start reading from here.

// go back to original position
f.seek(origPos);