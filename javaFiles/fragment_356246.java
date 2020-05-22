public NumberTile[] removeAndTrim(NumberTile[] a, int index){
    NumberTile[] result = new NumberTile[a.length-1];
    for (int i = 0; i < result.length; i++){
       result[i] = a[((i < index) ? i : i + 1)];
    }
    return result;
}