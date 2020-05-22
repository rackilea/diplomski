public static String eightBitCharToBinary( char c ) {

    String charAsNineBits = Integer.toBinaryString( 0x100 | c & 0xff );
    return charAsNineBits.substring(1,5) + " " + charAsNineBits.substring(5,9);

}