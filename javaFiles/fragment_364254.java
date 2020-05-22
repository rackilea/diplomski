protected double[] cpi = { 10, 10.1, 10.3, 11.6, 13.7, 16.5 }
  protected CharSequence[] fromDate = { 
          "1914",
          "1915",
          "1916",
          "1917",
          "1918",
          "1919"};
  protected CharSequence[] toDate = { 
          "1914",
          "1915",
          "1916",
          "1917",
          "1918",
          "1919"};
String year1 = "1915";
String year2 = "1918";
indexYear1 = Arrays.asList(fromDate).indexOf(year1); //find the position (index) of year1 => 1
indexYear2 = Arrays.asList(toDate).indexOf(year2); //find the position (index) of year2 => 4
double factor = cpi[indexYear1] / cpi[indexYear2]; // => 10.1 / 13.7