boolean functionNameHere(int a, int i) {
    boolean matched;
    for (int iter = 0; iter < a; iter++) {
        if ((i + iter) % 25 == 0) {
            matched = true;
            break;
        }
    }
    return matched;
}