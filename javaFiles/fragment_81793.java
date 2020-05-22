/* pop the first element */
public Integer pop (ListElement head){
    Integer popped = head.getValue();
    head = head.getNext();
    return popped;
}