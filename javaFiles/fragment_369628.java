88      else if (targetClass.equals(Long.class)) {
89          BigInteger bigInt = null;
90          if (number instanceof BigInteger) {
91              bigInt = (BigInteger) number;
92          }
93          else if (number instanceof BigDecimal) {
94              bigInt = ((BigDecimal) number).toBigInteger();
95          }
96          // Effectively analogous to JDK 8's BigInteger.longValueExact()
97          if (bigInt != null && (bigInt.compareTo(LONG_MIN) < 0 || bigInt.compareTo(LONG_MAX) > 0)) {
98              raiseOverflowException(number, targetClass);
99          }
100         return (T) new Long(number.longValue());
101     }