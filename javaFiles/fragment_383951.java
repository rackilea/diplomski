int[] counts = new int[128];
for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    if (ch < 128) {
        counts[ch]++;
    } else {
        System.err.println("Character is out of range: "+ch);
    }
}