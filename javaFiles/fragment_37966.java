// "The elements upto -1 (=none) are sorted, from 0 are all greater or equal"
for (int i = 0; i < myArray.length-1; i++){

    // The elements upto  i-1 are sorted, from i are all greater or equal
    for (int s = i+1; s < myArray.length; s++) { // For the elements after i
        if (myArray[i] > myArray[s]) { // If there is a smaller one
            // Swap the elements at i and s:
            int oldValueAtI = myArray[i];
            myArray[i] = myArray[s]; 
            myArray[s] = oldValueAtI; 
        }
    }
    // myArray[i] is smallest for s > i
    // The elements upto  i are sorted, from i+1 are all greater or equal
}
// The elements upto s.length - 1 are sorted,
// from s.length (=none) are all greater or equal

// All elements are sorted