boolean[] results = new boolean[someNumbers.length]; 
    // you have to initialize it
for (int i = 0; i < someNumbers.length; i++) {
    results[i] = someNumbers[i] >= floor; // ? true : false is redundant
    // ^ you're setting the ith element of the array, not the whole array
}

return results;