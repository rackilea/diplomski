int count = 1;   // change to 0 if zero-indexed
Node p = null;   // previous
Node n = head;   // current

while(count < k) {
    if(n.next != null) {
        p = n;
        n = n.next;
        count++;
    } else
        break;
}

if(count == k){
    p.next = n.next;
    n.next = head;
    head = n;
}