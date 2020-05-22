for (int i = 0; i < nr_w; i++)
    dec_values[i] = 0;

for (FeatureNode lx : x) {
    int idx = lx.index;
    // the dimension of testing data may exceed that of training
    if (idx <= n) {
        for (int i = 0; i < nr_w; i++) {
            dec_values[i] += w[(idx - 1) * nr_w + i] * lx.value;
         }
    }
}