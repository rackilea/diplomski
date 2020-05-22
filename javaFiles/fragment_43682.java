static final int ALLELES = 2; // or however it is called... ;)

int q = 0;
for (int first = 0; first < ALLELES; first++) {
    for (int second = ALLELES; second < 2 * ALLELES; second++) {
        offSpring[q++] = new MonoCreature(gamete[first], gamete[second]);
    }
}