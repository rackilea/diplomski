try {
    // stuff that throws FileNotFoundException AND IOException
}
// good: FileNotFoundException is a child class of IOException - both checked
catch (FileNotFoundException fnfe) {
    // TODO
}
catch (IOException ioe) {
    // TODO
}