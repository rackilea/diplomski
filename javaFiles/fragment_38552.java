int i = 1;
File file;
while((file = new File("file "+i+".pdf")).exists()) {
    // do whatever
    ++i;
}