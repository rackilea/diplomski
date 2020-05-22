public String getFmtWeight()
    {
          NumberFormat nf = NumberFormat.getNumberInstance();
          DecimalFormat df = (DecimalFormat)nf;
          df.applyPattern("#0.00");

          try {
              if(Double.isNaN(Double.parseDouble(totalweight)))       
                  return totalweight;
              else
                  return df.format(Double.parseDouble(totalweight));

          } catch ( NumberFormatException ex ) {
              /* thrown when the String can't be parsed as a double */
              return totalweight; // if 'totalweight' is the String you want to parse
          }
    }