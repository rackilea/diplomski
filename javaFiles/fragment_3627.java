String new_name = getFilename(file);
try {
    renameFiles(files[i], new_name);
} catch (IOException e) {
    //handle the exception
    //using a basic approach
    e.printStacktrace();
}