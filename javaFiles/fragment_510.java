// Grow array when array is full.
if (numberofitems >= data.length) GrowArray();

// Append to the end, at this point we always have enough space.
data[numberofitems++] = value;

// data[i] holds the new item
// Loop until we reach the head (i==0) or data[i]>=data[i-1]
for (int i = numberofitems - 1;
     i > 0 && data[i].compareTo(data[i-1]) < 0;
     i--) {
    // Swap data[i] (the new item) with its predecessor.
    String t = data[i-1];
    data[i-1] = data[i];
    data[i] = t;
}