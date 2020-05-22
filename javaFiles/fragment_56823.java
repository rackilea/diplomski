// create a currency for US locale
      Locale locale = Locale.US;
      Currency curr = Currency.getInstance(locale);

      // get and print the symbol of the currency
      StringBuilder symbol =  new StringBuilder(curr.getSymbol(locale));
      System.out.println("Currency symbol is = " + symbol);