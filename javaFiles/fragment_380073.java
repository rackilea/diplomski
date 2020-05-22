long n = 1000000000000000L;
int zeroBitsCount = 0;
while (n > 0) {
    if (n % 2 == 0) {
        zeroBitsCount++; // counts the number of non-leading 0 bits
    }
    n = n >> 1; // divide n by 2 in order to examine the next bit in the next iteration
}
long total = 1L << zeroBitsCount; // the total is 2^(the 0 bits count)