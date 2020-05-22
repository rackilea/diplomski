NumberFormat numberInstance = new NumberFormat() {
    @Override
    public Number parse(String str) {
        return super.parse(str.toUpperCase());
    }
};