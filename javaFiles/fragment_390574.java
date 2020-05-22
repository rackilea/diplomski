public int getMax() {
    int max = -1;
    for(int j=0; j<nElems; j++) {
        if(max < array[j])
            max = array[j];
    }
    return max;
}