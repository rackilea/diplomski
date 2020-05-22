public void display() {
    if(start == null) {
        System.out.println("\nThe list is empty!");
    } 
    else {
        Node temp = start;

        while(temp != null) {
            System.out.println("ID : " + temp.getID() +  " Name : " + temp.getName());
            temp = temp.getNext();
        }
    }
}