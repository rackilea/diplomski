class QuoteProductDTO {
    public String name;
    public int value1;
    public double value2;

    public QuoteProductDTO(String name, int value1,
            double value2) {
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String toString() {
        return name + ", " + value1 + ", " + value2;
    }
}