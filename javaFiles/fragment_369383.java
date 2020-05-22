MyInterface {
    int getOne();
    String getTwo();
    ...

    boolean isEqualTo(MyInterface that) {
        return that != null &&
            this.getOne() == that.getOne() &&
            this.getTwo().equals(that.getTwo()) && //add null checks!

            ...;
    }
}