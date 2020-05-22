package testing;

import java.util.Base64;

public class SimpleTest {

    public static void main(String[] args) {

        // An array containing six bytes to encode and decode.
        byte[] fullArray = { 0b01010101, (byte) 0b11110000, (byte)0b10101010, 0b00001111, (byte)0b11001100, 0b00110011 };

        // The same array broken into three chunks of two bytes.

        byte[][] threeTwoByteArrays = {
            {       0b01010101, (byte) 0b11110000 },
            { (byte)0b10101010,        0b00001111 },
            { (byte)0b11001100,        0b00110011 }
        };
        Base64.Encoder encoder = Base64.getEncoder().withoutPadding();

        // Encode the full array

        String encodedFullArray = encoder.encodeToString(fullArray);

        // Encode the three chunks consecutively 

        StringBuilder encodedStringBuilder = new StringBuilder();
        for ( byte [] twoByteArray : threeTwoByteArrays ) {
            encodedStringBuilder.append(encoder.encodeToString(twoByteArray));
        }
        String encodedInChunks = encodedStringBuilder.toString();

        System.out.println("Encoded full array: " + encodedFullArray);
        System.out.println("Encoded in chunks of two bytes: " + encodedInChunks);

        // Now  decode the two resulting strings

        Base64.Decoder decoder = Base64.getDecoder();

        byte[] decodedFromFull = decoder.decode(encodedFullArray);   
        System.out.println("Byte array decoded from full: " + byteArrayBinaryString(decodedFromFull));

        byte[] decodedFromChunked = decoder.decode(encodedInChunks);
        System.out.println("Byte array decoded from chunks: " + byteArrayBinaryString(decodedFromChunked));
    }

    /**
     * Convert a byte array to a string representation in binary
     */
    public static String byteArrayBinaryString( byte[] bytes ) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for ( byte b : bytes ) {
            sb.append(Integer.toBinaryString(Byte.toUnsignedInt(b))).append(',');
        }
        if ( sb.length() > 1) {
            sb.setCharAt(sb.length() - 1, ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}