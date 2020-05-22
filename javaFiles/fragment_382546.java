Linked root = new Linked("Auto",null); //here Linked constructor takes 2 parameters, the element and the next pointer.
//Since you only inserted one element so far, the next element should be null.

//Insert another element
insertAtEnd("Moto");

public void insertAtEnd(String element){
    Linked curr = root;
    while(curr.next != null) curr = curr.next;
    curr.setNext(new Linked(element,null);
}

public Linked findElement(String element){
    Linked curr = root;
    while(curr!=null){
         if(curr.getElement().equals(element)) return curr;
         else curr = curr.next;
    }
    return null; //element not found
}