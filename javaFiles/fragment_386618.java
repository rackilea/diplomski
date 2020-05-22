public PoplFormative(int writer) {
    this.writerId = writer;
    if (writerId == 1) {
        this.otherWriter = PoplFormative.writer7;
    }
    else if (writerId == 7) {
        this.otherWriter = PoplFormative.writer1;
    }
    else {
        System.out.println("Big nasty error occurred");
        while (true) {
        }
    }
}