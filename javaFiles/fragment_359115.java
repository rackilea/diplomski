void r_nCr(const unsigned int &startNum, const unsigned int &bitVal, const unsigned int &testNum) // Should be called with arguments (2^r)-1, 2^(r-1), 2^(n-1)
{
    unsigned int n = (startNum - bitVal) << 1;
    n += bitVal ? 1 : 0;

    for (unsigned int i = log2(testNum) + 1; i > 0; i--) // Prints combination as a series of 1s and 0s
        cout << (n >> (i - 1) & 1);
    cout << endl;

    if (!(n & testNum) && n != startNum)
        r_nCr(n, bitVal, testNum);

    if (bitVal && bitVal < testNum)
        r_nCr(startNum, bitVal >> 1, testNum);
}