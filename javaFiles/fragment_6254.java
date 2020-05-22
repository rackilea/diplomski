// For each of the 56 bits
for (i = 0; i < 56; i++)
{
    L = PC1[i];                 // Get i-th bit index
    L_byte = L >>> 3;           // Get the byte where that bit is stored
    L_mask = 0x80 >>> (L & 7);  // Get the bit mask
    if (kb[L_byte] & L_mask] != 0)
    {
        // The PC1[i]-th bit of kb is set
        // so set bit at position 55-i (i=0 => MSB) in pc1m
        pc1m |= (1L << (55-i));
    }
}