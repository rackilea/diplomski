...
while (wordScan.hasNext()) {
    String temp = wordScan.next();
    MyNode node = new MyNode();
    MyNode node2 = new MyNode();
    node.setWord(temp);
    node2.setWord(temp);
    node.setLength(temp.length());
    node2.setLength(temp.length());
    ll.InsertToHead(node2);
...