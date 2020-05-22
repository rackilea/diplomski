/**
 * Converts an unsigned big endian value within the buffer to the same value
 * stored using ASCII digits. The ASCII digits may be zero padded, depending
 * on the value within the buffer.
 * <p>
 * <strong>Warning:</strong> this method zeros the value in the buffer that
 * contains the original number. It is strongly recommended that the input
 * value is in fast transient memory as it will be overwritten multiple
 * times - until it is all zero.
 * </p>
 * <p>
 * <strong>Warning:</strong> this method fails if not enough bytes are
 * available in the output BCD buffer while destroying the input buffer.
 * </p>
 * <p>
 * <strong>Warning:</strong> the big endian number can only occupy 16 bytes
 * or less for this implementation.
 * </p>
 * 
 * @param uBigBuf
 *            the buffer containing the unsigned big endian number
 * @param uBigOff
 *            the offset of the unsigned big endian number in the buffer
 * @param uBigLen
 *            the length of the unsigned big endian number in the buffer
 * @param decBuf
 *            the buffer that is to receive the BCD encoded number
 * @param decOff
 *            the offset in the buffer to receive the BCD encoded number
 * @return decLen, the length in the buffer of the received BCD encoded
 *         number
 */
public static short toDecimalASCII(byte[] uBigBuf, short uBigOff,
        short uBigLen, byte[] decBuf, short decOff) {

    // variables required to perform long division by 10 over bytes
    // possible optimization: reuse remainder for dividend (yuk!)
    short dividend, division, remainder;

    // calculate stuff outside of loop
    final short uBigEnd = (short) (uBigOff + uBigLen);
    final short decDigits = BYTES_TO_DECIMAL_SIZE[uBigLen];

    // --- basically perform division by 10 in a loop, storing the remainder

    // traverse from right (least significant) to the left for the decimals
    for (short decIndex = (short) (decOff + decDigits - 1); decIndex >= decOff; decIndex--) {

        // --- the following code performs tail division by 10 over bytes

        // clear remainder at the start of the division
        remainder = 0;

        // traverse from left (most significant) to the right for the input
        for (short uBigIndex = uBigOff; uBigIndex < uBigEnd; uBigIndex++) {

            // get rest of previous result times 256 (bytes are base 256)
            // ... and add next positive byte value
            // optimization: doing shift by 8 positions instead of mul.
            dividend = (short) ((remainder << 8) + (uBigBuf[uBigIndex] & 0xFF));

            // do the division
            division = (short) (dividend / 10);

            // optimization: perform the modular calculation using
            // ... subtraction and multiplication
            // ... instead of calculating the remainder directly
            remainder = (short) (dividend - division * 10);

            // store the result in place for the next iteration
            uBigBuf[uBigIndex] = (byte) division;
        }
        // the remainder is what we were after
        // add '0' value to create ASCII digits
        decBuf[decIndex] = (byte) (remainder + '0');
    }

    return decDigits;
}

/*
 * pre-calculated array storing the number of decimal digits for big endian
 * encoded number with len bytes: ceil(len * log_10(256))
 */
private static final byte[] BYTES_TO_DECIMAL_SIZE = { 0, 3, 5, 8, 10, 13,
        15, 17, 20, 22, 25, 27, 29, 32, 34, 37, 39 };