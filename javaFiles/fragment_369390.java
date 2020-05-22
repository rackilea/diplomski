class Price extends Money {

    @Min(0)
    int getAmount() {
        return super.getAmount();
    }

}