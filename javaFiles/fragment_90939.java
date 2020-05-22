int numberOfDecimalPlaces = 6;

BigDecimal bigDecimal = new BigDecimal(11212.122323);
bigDecimal.setScale(numberOfDecimalPlaces, RoundingMode.HALF_UP);

NumberFormat numberFormat = NumberFormat.getInstance();
numberFormat.setMinimumFractionDigits(numberOfDecimalPlaces);

System.out.println(numberFormat.format(bigDecimal));