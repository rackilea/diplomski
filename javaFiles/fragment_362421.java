char allLetters[] = new char[3700];
int max = 122;
int min = 65;

for (int i = 1; i <= 75; i++) {
    char next;
    do {
        next = (char)(Math.random() * (max - min) + min);
    } while (next > 90 && next < 97);
    allLetters[i] = next;
    if (i % 25 != 0) {
        System.out.printf("%s,", next);
    }
    else {
        System.out.printf("%s\n", next);
    }
}