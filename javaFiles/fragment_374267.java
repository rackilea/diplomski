int dividend = 6;
int divisor  = 2;
int n1 = Integer.SIZE - Integer.numberOfLeadingZeros(dividend);
int n2 = Integer.SIZE - Integer.numberOfLeadingZeros(divisor);
int n = n1 >= n2 ? n1 : n2;
int dividend_Hi = dividend >> n;
int dividend_Lo = dividend & ((1 << n) - 1);

for (int i = 0; i < n; i++) {
    dividend <<= 1;
    dividend_Hi = dividend >> n;
    if (dividend_Hi >= divisor) {
        dividend_Hi -= divisor;
        dividend++;
    }
    dividend_Lo = dividend & ((1 << n) - 1);
    dividend = dividend_Hi << n | dividend_Lo;
}