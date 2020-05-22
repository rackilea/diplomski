public Object dequeue() throws QueueUnderflowException
{
    if (isEmpty())
        throw new QueueUnderflowException("Dequeue attempted on an empty queue.");
    else
    {
        Object element;                 // create a reference to the Object to return
        element = rear.getLink();       // set the reference to the information in the front node
        rear.setLink(element.getLink());          // set the rear reference to point at the next node

        return element;                 
    }// end else
}// end dequeue()