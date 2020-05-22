int getNumber(int index) {
    Random r = this.seed.clone();
    for (int i = 0; i < index - 1; ++i) {
        r.nextInt();
    }
    return r.nextInt();
}