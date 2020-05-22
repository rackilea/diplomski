if (orphan.compareTo(heap[largerChildIndex]) < 0) {
        heap[rootIndex] = heap[largerChildIndex];
        rootIndex = largerChildIndex;
        leftChildIndex = 2 * rootIndex;
        // increment the swap here as inside this block of reHeap only swap takes place.
        swap++
 }