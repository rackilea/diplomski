void draw() {
    background(0);

    IntList  swapped = new IntList();

    float len = lines.length;
    //do this for the entire array 
    if (i < len) {
        for (j = 0; j < len-i-1; j++) {
            float a = lines[j];
            float b = lines[j + 1];
            if (a > b) {
                swapped.append(j);
                swapped.append(j+1);
                swap(lines, j, j+1);
            }
        }
    } else {
        noLoop();
        i++;
    }

    for (int i = 0; i < len; i++) {
        if ( swapped.hasValue(i) )
            stroke(255, 0, 0);
        else
            stroke(255);
        line(i, height, i, height - lines[i]);
    }
}