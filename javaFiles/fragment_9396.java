public class PriceTableCell<S> extends TableCell<S, Long> {

    private final AnchorPane pane ;
    private final Label valueLabel ;
    // locale-aware currency format to use for formatting
    private DecimalFormat format;

    public PriceTableCell() {
        // grab an instance
        format = (DecimalFormat) NumberFormat.getCurrencyInstance();
        //get the currency symbol
        String symbol = format.getCurrency().getSymbol();
        // replace the currency symbol with an empty string
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        symbols.setCurrencySymbol("");
        format.setDecimalFormatSymbols(symbols);

        Label currencySignLabel = new Label(symbol);
        valueLabel = new Label();
        pane = new AnchorPane(currencySignLabel, valueLabel);
        AnchorPane.setLeftAnchor(currencySignLabel, 0.0);
        AnchorPane.setRightAnchor(valueLabel, 0.0);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }

    @Override
    protected void updateItem(Long price, boolean empty) {
        super.updateItem(price, empty);
        if (empty) {
            setGraphic(null);
        } else {
            // manual formatting 
            //String text = String.format("%,d.%02d", price / 100, Math.abs(price % 100));
            valueLabel.setText(format.format(price));
            setGraphic(pane);
        }
    }
}