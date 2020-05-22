public void onTextChanged(CharSequence s, int start,
                                    int before, int count) {
        FinalAutoPrice = Double.parseDouble(FinalAutoPriceText.getText().toString());
        TradeInPrice = Double.parseDouble(TradeInPriceText.getText().toString());
        TotalAfterTrade = FinalAutoPrice - TradeInPrice;
        PriceAfterTradeText.setText(String.valueOf(TotalAfterTrade));
       }