// Unsigned shift by 32 bits, so top 32 bits of topBits will be 0,
// bottom 32 bits of topBits will be the top 32 bits of l
long topBits = l >>> 32;

// XOR topBits with l; the top 32 bits will effectively be left
// alone, but that doesn't matter because of the next step. The
// bottom 32 bits will be the XOR of the top and bottom 32 bits of l
long xor = l ^ topBits;

// Convert the long to an int - this basically ditches the top 32 bits
int hash = (int) xor;