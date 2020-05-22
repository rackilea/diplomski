Data[] data; // array of data
Data shortest = data[0]; // initialize shortest variable
for(int i = 1; i < data.length; i++) {
    if(data[i].pathLength < shortest.pathLength)
        shortest = data[i];
}