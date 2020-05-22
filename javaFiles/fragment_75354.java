StringReader sr = new StringReader("This is a test string");
int i;               // <-- changed from char
do {
    i = sr.read();

    // ... and if you need a char...
    char c = (char) i;

} while (i != -1);   // <-- works :-)