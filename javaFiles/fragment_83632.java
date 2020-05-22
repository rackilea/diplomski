... else {
    char[] bases = dna.toCharArray();
    char[] newBases = new char[bases.length];
    for (int i = 0; i < bases.length; i++) {
        newBases[i] = myOtherMethod(bases[i]);
    }
    return new String(newBases);
}