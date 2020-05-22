B () {
    Random r = new Random();
    c = new C[5];
    // Don't declare or initialize it here: int[] t;  = new int[5];

    for (int i=0; i<5; i++) {
        int t[] = new int[5];           // *** Keep it specific to the loop, and
                                        //     create a new one each iteration
        for (int j=0; j<5; j++) {
            t[j] = r.nextInt(10) + 1;
        }
        c[i] = new C(t);
    }

    for (int k=0; k<5; k++) {
        c[k].print();
    }
}