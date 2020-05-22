// Method declaration, takes a two-demensional array of integers
public static int process(int [][] data) {
    // Create a one-demensional array of Objects, containing 
    // a single element, `0`.  This will be "auto-boxed" from
    // a primitive int to an Integer object.
    final Object[] c = new Object[]{0};
    // Create a one dimensional array of Objects, of the same
    // size as the first dimension of data
    Object[] p = new Object[data.length];

    // Loop through each index of the array p, declared above
    for (int i = 0; i < p.length; i++) {
        // get a reference, r, to the ith "row" of data
        final int [] r = data[i];
        // create a new Thread, and store a reference to it in p[i]
        p[i] = new Thread() {
            // This is the method that will be invoked on a separate
            // thread of execution by the java virtual machine
            public void run() {
                for (int s0 = 0, s1 = 0; s0 < r.length - 1; s0++, s1 = s0 + 1) {
                    if (r[s0] > r[s1]) {
                        // perform an xor-swap of two elements in the
                        // array (as pointed out by Jongware)
                        r[s0] ^= r[s1]; r[s1] ^= r[s0]; r[s0] ^= r[s1];
                        // this access of c[0] is not thread-safe
                        c[0] = ((Integer) c[0]) + 1;
                    }
                }
            }
        };
    }
    // return the value in c[0]
    return (Integer) c[0];
}