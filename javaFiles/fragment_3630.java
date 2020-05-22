String new_name = getFilename(file);
boolean result = renameFiles(files[i], new_name);
if (!result) {
    //the file couldn't be renamed
    //notify user about this
    System.out.println("File " + files[i].getName() + " couldn't be updated.");
}