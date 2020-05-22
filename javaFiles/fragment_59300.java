public void printList(){
    Node temp = head;
    while (temp != null && temp.nextNode != null){
        System.out.print(temp.data + " " );
        temp = temp.nextNode;
    }
    // print last node here
    System.out.print(temp.data);
    temp = temp.nextNode; 
}