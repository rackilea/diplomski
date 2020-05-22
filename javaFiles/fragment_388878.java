public static class Stock{
    // The possible characters of a stock - note length is < 64
    private final static String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.";

    //Will be 6 for given valid chars, but coding it like this prevents bugs later
    private final static int shiftAmnt = (int)(Math.log(alphaNumeric.length()) / Math.log(2)) + 1;

    private String stock;

    public Stock(String s) {
      stock = s;
    }

    @Override
    public boolean equals(Object o) {
      return o instanceof Stock && stock.equals( ((Stock)o).stock);
    }

    @Override
    public int hashCode() {
      int code = 0;
      for (char c : stock.toCharArray()) {
        code = code << shiftAmnt;
        code += alphaNumeric.indexOf(c);
      }
      return code;
    }
  }