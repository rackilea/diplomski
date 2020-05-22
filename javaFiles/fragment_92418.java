int n = 28;  // Decimal value
int bits = 10;   // Size of the binary result
char[] array = new char[bits];
for (int i=0; i<bits; i++)  // Initialize to zeroes
    array[i] = '0';
binary(n, array, bits);   // Start the recursion