int areasIterable=0
for (int i = 0; i < haystack.length; i++) {
    for (int j  =0; j < haystack[i].length; j++) {
        if(haystack[i][j].getArea() > threshold) {
            areas[areasIterable] = haystack[i][j].getArea();
            areasIterable=areasIterable+1;
        }        
    }
}