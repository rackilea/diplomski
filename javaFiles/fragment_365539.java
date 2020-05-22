// define the indexes where you would like the array
// subset to start
int[] origin = new int[] {timeIndex, depthIndex, 0, 0};

// define the overall size of the read to be done, starting
// at origin
int[] size = new int[] {1, 1, latSize, lonSize};

// read the subset
Array data4D = v.read(origin, size);

// remove any dimensions of size 1
Array data2D = data4D.reduce();