} else {// works
    CNode currNode = lastC;

    CNode newNode = b.firstC;
    for (int i = 1; i < b.length + 1; i++) {
        currNode.next = newNode;

        currNode = newNode;

        newNode = currNode.next;

        length++;
    }
    lastC = currNode;
}