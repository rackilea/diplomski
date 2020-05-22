public class MyNumberFormat extends NumberFormat {
    protected MyNumberFormat(String pattern, CurrencyData cdata, boolean userSuppliedPattern) {
      super(createMyNumberConstants(NumberFormat.defaultNumberConstants), pattern, cdata, userSuppliedPattern);
  }

    public static MyNumberFormat getFormat(String pattern) {
      return new MyNumberFormat(pattern, CurrencyList.get().getDefault(), true);
  }

protected static final NumberConstants createMyNumberConstants(
      final NumberConstants orig) {
  return new NumberConstants() {
      @Override
      public String currencyPattern() {
          return orig.currencyPattern();
      }

      @Override
      public String decimalPattern() {
          return orig.decimalPattern();
      }

      @Override
      public String decimalSeparator() {
          return decimalSeparator();
      }

      @Override
      public String defCurrencyCode() {
          return orig.defCurrencyCode();
      }

      @Override
      public String exponentialSymbol() {
          return orig.exponentialSymbol();
      }

      @Override
      public String globalCurrencyPattern() {
          return orig.globalCurrencyPattern();
      }

      @Override
      public String groupingSeparator() {
          return orig.groupingSeparator();
      }

      @Override
      public String infinity() {
          return orig.infinity();
      }

      @Override
      public String minusSign() {
          return orig.minusSign();
      }

      @Override
      public String monetaryGroupingSeparator() {
          return orig.monetaryGroupingSeparator();
      }

      @Override
      public String monetarySeparator() {
          return orig.monetarySeparator();
      }

      @Override
      public String notANumber() {
          return "?";
      }

      @Override
      public String percent() {
          return orig.percent();
      }

      @Override
      public String percentPattern() {
          return orig.percentPattern();
      }

      @Override
      public String perMill() {
          return orig.perMill();
      }

      @Override
      public String plusSign() {
          return orig.plusSign();
      }

      @Override
      public String scientificPattern() {
          return orig.scientificPattern();
      }

      @Override
      public String simpleCurrencyPattern() {
          return orig.simpleCurrencyPattern();
      }

      @Override
      public String zeroDigit() {
          return "0";
      }
  };