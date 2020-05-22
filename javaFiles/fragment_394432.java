while (idx < num)
{
    int largestChild = idx*2+1;
    if (largestChild >= num) break; // idx is at a leaf level
    if (largestChild+1 < num)
    {
        // compare the two children
        if (names[largestChild].compareTo(names[largestChild+1]) < 0)
        {
            largestChild = largestChild+1;
        }
    }
    if (names[idx] < names[largestChild])
    {
        // swap, moving the item down
        temp = names[idx];
        names[idx] = names[largestChild];
        names[largestChild] = temp;
        idx = largestChild;
    }
    else
    {
        // item is in the proper place
        break;
    }
}