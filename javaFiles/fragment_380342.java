// Takes hex string with low nibble first as produced by Perl's unpack 'h*'
// For example, 031323 => 0x30, 0x31, 0x32
public static byte[] hexLoHiStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte)(
              (Character.digit(s.charAt(i+0), 16) << 4)
            |  Character.digit(s.charAt(i+1), 16)
        );
    }

    return data;
}