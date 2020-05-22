public static void product(Node curr, int value) {
    if (curr == null) {
        return;
    }
    else {
        int data = value * curr.getData();  // compute current product
        curr.setData(data);                 // update Node
        product(curr.getNext(), data);      // make recursive call
    }
}