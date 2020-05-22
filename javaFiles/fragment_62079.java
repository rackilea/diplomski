public void ADD(E num) {
    Node<E> temp = new Node<>(num);
    if (this.head == null) {
        this.head = temp;
        System.out.println("Was empty");
    } else {


        Node<E> lead = this.head;
        Node<E> prev = null; //modified

        //first check if it should be added at the front
        if (lead.info.compareTo(temp.info) == 1) { 
           temp.next = this.head;
           this.head = temp;
           System.out.println("added to front of list");
           return;
        }

        while (lead != null) {

            //if (lead.info.compareTo(temp.info) == -1) {//If the lead.info is less than the argument then -1 is returned.
            if (lead.next == null && lead.info.compareTo(temp.info) == -1){ //if at the end of the list and lead.info is less than the argument, add to the end

                //lastNode().next = temp; // adds to the end of linked list
                lead.next = temp;
                System.out.println("added to end of list");
                return; //return if node was added

            } 
            if (lead.info.compareTo(temp.info) == 1) { //if the greater than we swap out

                //Node<E> z = lead;
                prev.next = temp;
                temp.next = lead;
                //lead = temp;
                //lastNode().next = lead; //not needed if you use prev
                //lead=lead.next;
                System.out.println("added inside of list");
                return; //return if node was added

            }
            prev = lead; //added this, keep prev one behind lead
            lead=lead.next;

        }
    }

}