sort(Node head_p){ //do not change the head, or you will lose the beginning.
Node tmp_p; 
Node curr_p = head_p; 
while(curr_p != NULL){ 
if(curr_p.poly.term.degree < curr_p.next.poly.term.degree) //either degree is smaller or greater 
{//swap 
    tmp_p = curr_p; //save first element
    curr_p = curr_p.next; //set first element to second
    //now the 2 element is the actual third element so we need 
    //to put the first between the second and the third
    tmp_p.next = curr_p.next; //set next of first to third
    curr_p.next = tmp_p; //set second element to the first that we saved before
}
curr_p = curr_p.next; //move to next element...rinse repeat
}
}