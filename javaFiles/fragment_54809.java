private void bubbleDown(int index)
{
    boolean found = false;
    while(!found && (2*index +1) < size)
    {
        int left = leftChild(index) + 1;
        int right = rightChild(index) + 1;
        int child = left;

        if((index*2 +2) < size && elementData[right].compareTo(elementData[left]) > 0)
        {
            child = right;
        }
        if(elementData[index].compareTo(elementData[child]) < 0)
        {
            swap(elementData, index, child);
            index = child;
        }
        else
        {
            found = true;
        }
    }
}