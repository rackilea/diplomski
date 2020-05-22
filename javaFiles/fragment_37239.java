class Horse implements Comparable<Horse> {
    private String name;
    private float amount;

    public Horse(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s with $%.2f", name, amount);
    }

    @Override
    public int compareTo(Horse o) {
        return Comparator.comparing((Horse h) -> h.amount)
                    .thenComparing((Horse h) -> h.name).compare(this, o);
    }
}