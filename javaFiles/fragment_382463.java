public void printReversList(Node head) {

    Node current = head; // used to search through the list
    Node last    = null; // stores the last element that we printed

    while (last != head) { // = we didn't print everything yet

        // find next element to print - it's one element before we reach "last"
        while (current.next != last) {
            current = current.next;
        }

        // Store the current element as the new last and print it
        last  = current;
        system.out.print(last.value);

        // reset current and start all over
        current = head;
    }
}