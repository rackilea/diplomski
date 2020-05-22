for(int j = 0; j < output; j++) {
    // NOTE the line:
    float sum = 0;
    // and the reference to inner array:
    byte[] row = weights[j];
    for(int i = 0; i < input; i++) {
        sum += inputs[i] * row[i];
    }

    outputs[j] = sum;
}