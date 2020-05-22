public boolean replace(int element, int index) {
    Node temp= new Node(pElement);
    Node current = getHead();
    if (!isEmpty()) {

        //Run for loop one less than index value.
        for (int i = 0; i < index -1 && current.getNext() != null; i++) {
            current = current.getNext();
        }

        // At this point current points to element 3.
        // Set next element of node 4 as a next element of new element 10.

        temp.setNext(current.getNext().getNext());

        // at this point we have two references for element 5 like below
        // [0]->[1]->[2]->[3]->[4]->[5]->[6]->[7]->[8]->[9]->[10]
        // [10]->[5]->[6]->[7]->[8]->[9]->[10]

        // Set null to next element of of element 4 to remove reference to
        // element 5
        current.getNext().setNext(null);

        // At this point we have two list as below:
        // [0]->[1]->[2]->[3]
        // [10]->[5]->[6]->[7]->[8]->[9]->[10]

        // Set new element as next of current element (current element is 3)
        current.setNext(temp);

       // here we have replaced the element 4 with element 10

        listCount++;
        return true;
    }
    return false;
}