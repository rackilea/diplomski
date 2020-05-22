// create list as demo
var list = new ArrayList<String>();
for (int i = 0; i < 13; i++) {
    list.add(Integer.toString(i));
}

int batchSize = 3;

// the code
int offset = 0;
while (offset < list.size()) {
    // make sure the end offset doesn't go past the end
    int endOffset = Math.min(offset + batchSize, list.size());

    // call or add it to anything else, or even use streaming afterwards
    System.out.println(list.subList(offset, endOffset));
    offset = endOffset;
}