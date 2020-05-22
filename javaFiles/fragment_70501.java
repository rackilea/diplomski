public static int[] letterFrequency(String url) throws IOException {
    Reader inn = new InputStreamReader(new BufferedInputStream((new URL(url)).openStream()), "UTF-8");
    char[] c = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', 'æ', 'ø', 'å'
    };
    String chars = new String(c);

    int[] total = new int[c.length];
    int read;
    while ((read = inn.read()) != -1) {
        read = Character.toLowerCase(read);
        int index = chars.indexOf(read);
        if (index != -1) {
            total[index]++;
        }
    }
    return total;
}