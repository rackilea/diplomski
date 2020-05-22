private static boolean isPangrams(String ip) {
    int flags = 0;
    for(char current : ip.toLowerCase().toCharArray()) {
        if (current >= 'a' && current <= 'z') {
            flags |= 0x01<<(current-'a');
        }
    }
    return flags == 0x3ffffff;
}