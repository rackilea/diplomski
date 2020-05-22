int largest = -1;
LinkedList<String> largestLinkedList = null;
for (LinkedList<String> ll : listOfLinkedLists) {
    if (ll.size() > largest) {
        largestLinkedList = ll;
        largest = ll.size();
    }
}