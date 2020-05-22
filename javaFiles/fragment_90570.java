byte[] b;
    b = str.getBytes();
    byte[] output = new byte[b.length + 4];
    output[0] = 0;
    output[1] = 1;
    output[2] = 2;
    output[3] = 5;
    for (int i = 0; i < b.length; i++) {
    output[i + 4] = b[i];
    }
    return output;
}````