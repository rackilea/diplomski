public void setSomeValue(int someValue) {
    if (someValue <= 0) {
        throw new NumberFormatException("Some Value must be a positive value.");
    }
    this.someValue = someValue;
}