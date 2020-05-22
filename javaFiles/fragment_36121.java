Map<String, int[]> map = new HashMap<String, int[]>();

for(int i=0; i<1000; i++) {
    int[] arr = new int[200];
    for(int j=0; j<200; j++) {
        arr[j] = j;
    }
    map.put("Arr" + i, arr);
}