public void rlx (int x){
    While(head != null && (int)head.data <= x) {
        head = head.next
    }
    Link p = head;//Initializing a pointer equal to head 
    for (Link c = head.next; c!=null;c=c.next) {//Initializing another Pointer with the Condition to termination
        if((int)c.data<=x){
            p.next=c.next;//P.next skip c by pointing to c.next instead of c;
        }
        Else {
            p=c;
        }
    }
}