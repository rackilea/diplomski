@PrePersist
@PreUpdate
    public void pricePrecisionConvertion() {
        // convert your bigdecimal scale to 2 here
        this.price.setScale(2, RoundingMode.HALF_UP);
    }