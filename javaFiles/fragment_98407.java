// Reference the directory in which the files reside
File dir = new File("c:/my/test/directory");
// Go through the files in the directory in a loop
for ( File file : dir.listFiles()) {
    // Make sure that an entry is a file (it could be a directory)
    // and that its size is zero
    if (file.isFile() && file.length() == 0) {
        // If both conditions are true, delete the empty file
        file.delete();
    }
}