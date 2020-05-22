// this is where the SuffixTree instances will end up
List<SuffixTree> suffixes = new ArrayList<SuffixTree>();


String[] strings = new String[3];
for (String string : strings) {
    // A new suffix tree is created here but if you don't do anything
    // with it then it is marked as garbage collectable when the closed
    // curly brace is reached
    SuffixTree t = new SuffixTree(string);


    // Now I'm pushing the object into the suffixes list: this will prevent
    // the loss of the object currently stored in the t variable
    suffixes.add(t);
}