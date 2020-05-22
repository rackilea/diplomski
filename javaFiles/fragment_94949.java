int count = 0;

if (f.isDirectory()) {
    // Nothing comes out of the recursive call.
    // The result is completely lost
    getFileNums(f);
}