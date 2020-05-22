public void insert(Node element)
{
    NHeap[++size] = element;
    int current = size;

    while (NHeap[current].getID() < NHeap[parent(current)].getID())
    {
        swap(current,parent(current));
        current = parent(current);
    }   
}