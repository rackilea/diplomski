void outer() {
    for(int i = 0; i < 5; i++) {
        if(i < 3) {
            inner(i, 0);
        } else {
            for(int j = 0; j < 3; j++) {
                inner(i, j);
            }
        }
    }
}

void inner(int i, int j) {
    for(int k = 0; k < 9; k++) {
        //hell a lot of codes
    }
}