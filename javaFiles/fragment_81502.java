public double priceAfterDiscount() {
    if (price <= 0) {
        return 0;
    }
    return price - (price * DISCOUNT);
}

public String toString() {
    return title + " " + priceAfterDiscount();
}