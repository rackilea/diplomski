public void enqueue(Object element)
{
    LLObjectNode newNode = new LLObjectNode(element);

    if (rear == null){
        newNode.setLink(newNode);

    }else{
        newNode.setLink(rear.getLink()); 
        rear.setLink(newNode);      
    } 

    rear = newNode;   
}// end enqueue()