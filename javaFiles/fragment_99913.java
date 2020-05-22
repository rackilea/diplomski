private SalesTransactionTax checkInList(SalesTransactionTax stt) {
    return salesTransactionTaxList.stream()
            // To compare String is used equals()
            .filter(stt2 -> stt2.getCode().equals(stt.getCode()))
            // To compare BigDecimal is used compareTo()
            .filter(stt2 -> stt2.getRate().compareTo(stt.getRate()) == 0)
            // To compare boolean is used ==
            .filter(stt2 -> stt2.getIsFixed() == stt.getIsFixed())
            // If doesn't exist return null
            .findAny().orElse(null);
}