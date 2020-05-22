public static int getPredecessorv2(int[] inpArr, int key) {
    int minDiff = Math.abs(key);
    int pred = key;
    if(inpArr[0] < key) {
        minDiff = key - inpArr[0];
        pred = inpArr[0];
    } 
    for(int i=0;i<inpArr.length;i++) {
        if(inpArr[i] < key && (key - inpArr[i])<=minDiff)
        {
            minDiff = key - inpArr[i];
            pred = inpArr[i];
        }   
    }
    return pred;
}