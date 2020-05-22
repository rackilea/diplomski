Reader reader = new InputStreamReader(new FileInputStream("file"), "UTF-8");
char[] chars = new char[20];
int charsRead = -1;
while ((charsRead = read(reader, chars)) != -1) {
    // Process chars, the same caveats apply as above...
}