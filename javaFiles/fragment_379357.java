private void minHeapify(int pos)
{
    if (!isLeaf(pos))
    { 
        if ( NHeap[pos].getID() > NHeap[leftChild(pos)].getID()  || NHeap[pos].getID() > NHeap[rightChild(pos)].getID())
        {
            if (NHeap[leftChild(pos)].getID() < NHeap[rightChild(pos)].getID())
            {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            }else
            {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }
}