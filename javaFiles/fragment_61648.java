BigDecimal value = BigDecimal.ZERO;

for(int i = 0; i <= 10; i++) {
   value = value.add(BigDecimal.valueOf(0.1d));
   double doubleVal = value.doubleValue();
}