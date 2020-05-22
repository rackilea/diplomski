void merge(int bigger[], size_t bigger_len, int smaller[], size_t smaller_len) {
    ssize_t smaller_i, bigger_i, idx;

    if (smaller_len == 0)
        return;

    smaller_i = smaller_len-1;

    if (bigger_len == 0)
        bigger_i = -1;
    else
        bigger_i = bigger_len-1;

    idx = bigger_len+smaller_len-1;

    while (smaller_i >= 0 && bigger_i >= 0) {
        if (bigger[bigger_i] > smaller[smaller_i]) {
            bigger[idx] = bigger[bigger_i];
            bigger_i--;
        }
        else {
            bigger[idx] = smaller[smaller_i];
            smaller_i--;
        }
        idx--;
    }

    while (smaller_i >= 0) {
        bigger[idx] = smaller[smaller_i];
        smaller_i--;
        idx--;
    }
}