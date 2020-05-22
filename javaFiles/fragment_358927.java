String[][] in = {{"A1", "A2"}, {"B1", "B2"}};
String[][] inCopy = new String[in.length][in[0].length];
// inner arrays of inCopy are cloned to new memory, not shared with "in"
for (int i = 0; i < in.length; ++i) {
    inCopy[i] = in[i].clone();
}