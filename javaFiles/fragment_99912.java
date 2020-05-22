public void add(SalesTransactionTax inputValue) {
    SalesTransactionTax salesTransactionTax = checkInList(inputValue);
    if (salesTransactionTax != null) {
        // To sum operations the method used is add() from BigDecimal
        salesTransactionTax.setTaxAmount(salesTransactionTax.getTaxAmount().add(inputValue.getTaxAmount()));
    } else {
        this.salesTransactionTaxList.add(inputValue);
    }
}