class NumericComparator implements Comparator<String> {

     public int compare(String s1, String s2) {
      final Double i1 = getDouble(s1);
      final Double i2 = getDouble(s2);

      return (i1 == null) ? (i2 == null) ? 0 : -1 : (i2 == null) ? 1 : i1.compareTo(i2);
     }
     private Double getDouble(String number) {
          try {
               return Double.parseDouble(number);
          } catch(NumberFormatException e) {
               return null;
          }
     }
}