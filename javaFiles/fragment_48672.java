DataInputStream in = ... ;
PrintStream out = ... ;
...
while(hasData()) {
    String type = getNextType();
    DataParser parser = parsers.get(type);
    parser.parse(in, out);
}
// close streams and work on the output here