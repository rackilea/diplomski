while(temp != null)
{
    if(temp.data == num) {
        if(temp.previous != null) {
            temp.previous.next = temp.next;
        }
        // you have to link-up the next's previous with temp's previous too 
        if(temp.next != null) {
            temp.next.previous = temp.previous;
        }
        temp = null; // to deference the node and let garbage collector to delete/clear this node
        break; // don't return here otherwise size-- won't execute
    }
    temp = temp.next;
}