bool check(int flags) {
    int A = 1;
    int B = 2;
    int C = 4;

    return 
        flags == 0 ||
        flags == A ||
        flags == B ||
        flags == C;
}