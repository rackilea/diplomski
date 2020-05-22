BTree<?> t = null;
if( tokens[1].equals("DOUBLE")) {
    t = new BTree<Double>();
}
else if( tokens[1].equals("CHARACTER")) {
    t = new BTree<Character>();
}
else if( tokens[1].equals("INTEGER")) {
    t = new BTree<Integer>();
}
else if( tokens[1].equals("STRING")) {
    t = new BTree<String>();
}
// now you can use your 't'