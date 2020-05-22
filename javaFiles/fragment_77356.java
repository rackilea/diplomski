MultiValidator feeAmountValidaotr = new MultiValidator() {

    @Override
    protected IStatus validate() {
        // Only validate Fee Amounts if cheque can have fees
        BigDecimal fixedAmountValue = new BigDecimal(
                String.valueOf(((IObservableValue) fixedFeeAmountBinding.getTarget()).getValue())
                        .replaceAll(",", ""));
        BigDecimal variableAmountValue = new BigDecimal(
                String.valueOf(((IObservableValue) variableFeeAmountBinding.getTarget()).getValue())
                        .replaceAll(",", ""));
        BigDecimal totalAmountValue = new BigDecimal(
                String.valueOf(((IObservableValue) amountBinding.getTarget()).getValue()).replaceAll(",", ""));
        if (getModelObject().getClientChequePaymentRecordType().equals(ClientChequePaymentRecordType.INVOICE)
                && getModelObject().getInvoiceType() != null
                && !getModelObject().getInvoiceType().equals(InvoiceType.OTHER)) {
            if (fixedAmountValue.add(variableAmountValue).compareTo(totalAmountValue) == 0) {
                return ValidationStatus.OK_STATUS;
            }
            return ValidationStatus.error("Fee Amounts don't add up to Invoice Amount");
        }
        return ValidationStatus.OK_STATUS;
    }
};

dbf.addValidationStatusProvider(feeAmountValidaotr);