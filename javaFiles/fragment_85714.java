public int find(long searchKey) 
{
    int j;
    for(j=0; j<nElems; j++) {  // for each element,
        if(a[j] == searchKey)     // found search value?
            return j;                // then exit loop before end (exits entire function)
    }
    // reached end of for loop
    return -1;             // thus, can't find it
} // end find()
public void insert(long value) 
{
    a[nElems] = value;
    nElems++; 
}