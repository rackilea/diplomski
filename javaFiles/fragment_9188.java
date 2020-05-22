if (i == j) {
    return;
}
input[i] ^= input[j];
input[j] ^= input[i];
input[i] ^= input[j];