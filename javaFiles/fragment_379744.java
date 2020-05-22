StringBuilder orig = new StringBuilder("Mother");
Random rnd = new Random();

int maskSize = rnd.nextInt(orig.length()+1);

for (int i = 0; i < maskSize; i++) {
    int pos = rnd.nextInt(orig.length());

    while (orig.charAt(pos) == '*') {
        pos++;
        if (pos >= orig.length()) {
            pos = 0;
        }
    }

    orig.setCharAt(pos, '*');
}