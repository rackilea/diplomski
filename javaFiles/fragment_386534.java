int function(int a, int b, int c) {
    //If a == c: result = 0x00000000
    //Else:      result = 0xFFFFFFFF
    int result = (a - c | c - a) >> 31;

    //If a == c: result = 0x00000000 & (a ^ b) = 0
    //Else:      result = 0xFFFFFFFF & (a ^ b) = a ^ b
    result &= a ^ b;

    //If a == c: result = 0       ^ a = a
    //Else:      result = (a ^ b) ^ a = b
    result ^= a;

    return result;
}