final public static int multiplyDecimals( int[] decimalM1, int[] decimalN1, int[] result, int radix ){
    Arrays.fill( result, 0 );
    int lenM = decimalM1[0];
    int lenN = decimalN1[0];
    result[0] = lenM + lenN; 
    int iStepM = lenM;
    while( iStepM > 0 ){
        int iStepN = lenN;
        int iCarry = 0;
        while( iStepN > 0 ){
            int iPartial = decimalM1[iStepM] * decimalN1[iStepN] + result[iStepM + iStepN] + iCarry;
            result[iStepM + iStepN] = iPartial % radix;
            iCarry = iPartial / radix;
            iStepN--;
        }
        result[iStepM] = iCarry;
        iStepM--;
    }
    int xFirstDigit = 1;
    while( result[xFirstDigit] == 0 ) xFirstDigit++;
    if( xFirstDigit > 1 ){
        int ctDigits = result[0] - xFirstDigit + 1;
        for( int xDigit = 1; xDigit <= ctDigits; xDigit++ ) result[xDigit] = result[xDigit + xFirstDigit - 1];
        result[0] = ctDigits;
    }
    return result[0];
}