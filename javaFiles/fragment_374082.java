enum ExampleEnum {
    ONE, TWO, THREE;

    @Override
    public String toString() {
        switch (this) {
        case ONE:
            return "One";
        case TWO:
            return "Two";
        default:
            return "Three";
        }
    }
}