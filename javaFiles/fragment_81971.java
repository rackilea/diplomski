public class Iterator<E>
{
    private E[][] pointerToPointer;
    private E[] buffer; // underlying buffer.
    private int idx; // location of iterator in buffer.
    private E last_element; // last element returned by this iterator.

    public Iterator(E[][] pointerToPointer)
    {   
        this.pointerToPointer = pointerToPointer;
        buffer = pointerToPointer[0];
        idx = 0;

    }

     /**
     * Removes from the underlying collection the last element returned
     * by this iterator.
     */
    public void remove()
    {
        // create your new array (let's call it newArr)
        ...

        buffer = newArr;
        pointerToPointer[0] = buffer;
    }
}