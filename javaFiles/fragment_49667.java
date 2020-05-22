try {
    readfile(file);
}
catch (IOException ex) {
    throw new RuntimeException(ex);
}