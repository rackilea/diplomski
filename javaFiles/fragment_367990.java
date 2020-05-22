private BigDecimal addUpTotal(BillRec bill, BigDecimal runningTotal) {
    if (bill.getBillInfo().getBillSummAmtSize() > 0) {
        for (int x = 0; x < bill.getBillInfo().getBillSummAmtSize(); x++) {
            if (...) {
                runningTotal = runningTotal.add(...);
            }
        }
    }      
    return runningTotal;
}