public int getMax() {
    int max = -1;
    if (nElems > 0) {
        max = array[0];
        for(int j=1; j<nElems; j++) {
            if(max < array[j])
                max = array[j];
        }
    }
    return max;
}