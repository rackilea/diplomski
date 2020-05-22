//This will switch the current item with it's greatest child, if this child is
//larger than the current item itself.
private void percolateDown(int i){
    //Get n's greatest child. The two children are at position 2i+1 and 2i+2
    int n = getGreatestChild(i);

    //Don't do anything if the greater child is smaller or equal to the parent
    if( yourNumbersArray[n] <= yourNumbersArray[i] )
        return;

    //Now switch the parent with the greatest child

    //Make sure that the newly placed item is at the right spot by percolating it again.
    percolateDown(n);
}

private void initialize(){
    //Call the percolateDown() function for all items of your array.
    //Due to the heap nature you can leave out the second half, though. 
    int mid = yourNumbersArray.length/2;

//Start in the middle and work your way towards the front.
//This way you'll first sort the lowest level of your heap, then the second lowest, and so on.
    for(; mid>=0; --mid){
        percolateDown(mid);
    }
}