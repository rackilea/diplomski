String filename = "PremiershipResults.txt";
File fileref = new File(filename);
if (!fileref.exists()) {
    // file does not exist (note ! operator)
    // so go ahead and create it
}
else {
    // use the existing file
}