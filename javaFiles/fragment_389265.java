for (int i =0; i < length; i += 4) {
    double left = (double)((bytes [i] & 0xff) | (bytes[i + 1] << 8));
    double right = (double)((bytes [i + 2] & 0xff) | (bytes[i + 3] << 8));

    ... your code here ...

}