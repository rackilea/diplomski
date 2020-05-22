public Node removeKthToLast(Node head, int n) {
    if (head == null || n < 1)
        System.out.println("invalid");;

    int count = 0;
    Node temp = head;
    while (temp != null) { // count number of nodes in list
        temp = temp.next;
        count++;
    }

    if (n > count)
        System.out.println("n is greater than length of list");;

    int kthToLast = count - n;

    // remove first node 
    if(kthToLast == 0){
         head = head.next;
         return head;//end the method here when removing the 1st node
    }
    for (int i = 0; i < kthToLast - 1; i++) 
        head = head.next;

    head.next = head.next.next;
    return head;
    }