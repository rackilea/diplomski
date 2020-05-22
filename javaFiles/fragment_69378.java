public MyStringBuilder append(MyStringBuilder b) {
        if (length == 0) {
            firstC = new CNode(b.firstC.data);
            length = 1;
            CNode currNode = b.firstC;
            for (int i = 1; i < b.length; i++) {
                CNode newNode = new CNode(currNode.next.data);
                currNode.next = newNode;
                currNode = newNode;
                length++;
            }
            lastC = currNode;

        } else {// works
            CNode currNode = lastC;

            CNode bNode = b.firstC;
            for (int i = 1; i < b.length + 1; i++) {

                CNode newNode = new CNode(bNode.data);
                currNode.next = newNode;

                currNode = newNode;

                newNode = currNode.next;
                bNode = bNode.next;
                length++;
            }
            lastC = currNode;
        }
        return b;
    }