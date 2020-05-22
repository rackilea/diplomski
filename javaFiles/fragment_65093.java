private Computer noTaxComputer;
private Computer taxComputer;

public BigDecimal computePrice(Client c, ShoppingCart cart) {
    if (client.isSubjectToTaxes()) {
        return taxComputer.compute(cart);
    }
    else {
        return noTaxComputer.compute(cart);
    }
}