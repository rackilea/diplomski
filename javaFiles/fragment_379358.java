if (isLeaf(pos)) return;

int leftChild = leftChild(pos);
int rightChild = rightChild(pos);

int smallestChild = leftChild;
if (rightChild <= size && NHeap[rightChild] < NHeap[leftChild])
{
    smallestChild = rightChild;
}
if (NHeap[pos] > NHeap[smallestChild])
{
    swap(pos, smallestChild);
    minHeapify(smallestChild);
}