public void doIt(int k) {
    for (int i = 0; i < k; i++){
    search:
        for (int j = 0; j < i; j++){
            if (j == i){
                break search;
            }
        }
    }
}