public String toString() {
    String boi="";
    for(int x=0; x <= 9; x++) {
        int count=0;
        for (int y=0; y < numCount.length; y++) {
            if (x == numCount[y]) {
                count++;
            }
        }
        boi = boi + x + " - " + count + "\n";
    }      
    return boi;
}