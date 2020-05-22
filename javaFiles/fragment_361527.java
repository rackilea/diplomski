public void insertAtIndex(int x, int index){
    Element n = new Element(); 
    n.val = x; 

    if (head == null){ // If the list is empty
        head = n; // we insert the Element n as the first element
    }
    else{   
        Element h = head; // our current element we are looking at
        int currentIndex = 0;
        while (h.next!=null && currentIndex < index) { // increment until we reach the correct index
            h = h.next; // our Element h becomes the next Element added to the list        
            currentIndex++;
        }
        Element tail = h.next; // store the rest of the list in a temp variable, tail
        h.next = n; // we've reached the right index and/or the end, so add the element n here
        n.next = tail // reattach the tail 
    }
}