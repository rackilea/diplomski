for (int i = 0; i < myArray.length-1; i++){
    // Search the smallest in the rest:
    int smallestS = i;
    for (int s = i+1; s < myArray.length; s++) {
        if (myArray[s] < myArray[smallestS]) {
            smallestS = s;
        }
    }
    // Swap the elements at i and smallestS
    if (smallestS != i) { // Check not needed
        int oldValueAtI = myArray[i];
        myArray[i] = myArray[smallestS]; 
        myArray[smallestS] = oldValueAtI;
    } 
}