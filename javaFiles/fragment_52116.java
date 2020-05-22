public boolean odd(boolean a, boolean b, boolean c) {
    int count = 0;
    if (a) count++;
    if (b) count++;
    if (c) count++;
    return count % 2 != 0;   
}