private ChangeListener<Boolean> createListener(TextInputControl control) {

    return (obs, oldValue, newValue) -> {
        if ((! newValue) && ( !control.getText().trim().isEmpty() )) {
            SIMTradeCalculatorModel model = new SIMTradeCalculatorModel(numShares, purchasePrice, brokerage, callStrikePrice, putStrikePrice, putPremium, control);
                model.validateDecimal(control, errorDisplay, performCalculationButton);
                model.checkAllFields(performCalculationButton);
            } else {
                control.setText(control.getText().trim());
            }
        }
    };
}