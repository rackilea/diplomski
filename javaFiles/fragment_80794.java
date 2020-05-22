// initialize
results = new int[13];
// could be new int[11]; if you put results in array elements 0 to 10.

// ...

// add to tally
results[dicetotal]++;

// or, instead, pack the array because dice roll results can only be in 2 to 12. 
// Put such results in array element 0 to 10, 
// by subtracting 2 to the index before putting in
results[dicetotal - 2]++;