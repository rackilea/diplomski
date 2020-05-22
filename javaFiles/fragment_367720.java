while (heapSize>0)
{   
    min = A.get(0);

    A.set(0, A.get(heapSize-1));

    //decrement heapSize
    heapSize--;
    Heapify(A, 0);  
}