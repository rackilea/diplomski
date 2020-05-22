public class Money {

    private Currency currency;
    private Double value;

    public Currency getCurrency() { return currency; }
    public void setCurrency(Currency currency) { this.currency = currency; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }

    public boolean isValid() {
        if(getCurrency() == null || getValue() == null) {
            return false;
        }

        // critical logic goes here

        // sample code
        if("JPY".equalsIgnoreCase(currency.getCurrencyCode())) {
            int intValue = getValue().intValue();
            double diff = getValue() - intValue;
            if(diff > 0) {
                return false;
            }
        }

        /*double fractionValue = value - (value % (currency.getDefaultFractionDigits() * 10));
        if(fractionValue > currency.getDefaultFractionDigits() * 10) {
            return false;
        }*/

        return true;
    }

}