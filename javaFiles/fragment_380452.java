int res = 0;
int a = 10;
int b = 11;
int carry = 0;
for (int bit = 0 ; i != 8 ; i++) {
    int aBit = getBit(a, i);
    int bBit = getBit(a, i);
    int resBit = fullAdderGetResultBit(aBit, bBit, carry);
    carry = fullAdderGetCarryBit(aBit, bBit, carry);
    if (resBit == 1) {
        res |= 1 << i;
    }
}