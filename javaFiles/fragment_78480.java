String s = new StringBuilder()
                .append("Thats a nice joke ")
                .appendCodePoint(0x1F606)
                .appendCodePoint(0x1F606)
                .appendCodePoint(0x1F606)
                .append(" ")
                .appendCodePoint(0x1F61B)
                .toString();
char[] chars = s.toCharArray();
int index;
char ch1;
char ch2;

index = 0;
while (index < chars.length - 1) { // -1 because we're looking for two-char-long things
    ch1 = chars[index];
    if ((int)ch1 == 0xD83C) {
        ch2 = chars[index+1];
        if ((int)ch2 >= 0xDF00 && (int)ch2 <= 0xDFFF) {
            System.out.println("Found emoji at index " + index);
            index += 2;
            continue;
        }
    }
    else if ((int)ch1 == 0xD83D) {
        ch2 = chars[index+1];
        if ((int)ch2 >= 0xDC00 && (int)ch2 <= 0xDDFF) {
            System.out.println("Found emoji at index " + index);
            index += 2;
            continue;
        }
    }
    ++index;
}