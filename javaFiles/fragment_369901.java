BigDecimal a = new BigDecimal(1);
BigDecimal b = a.add(new BigDecimal(1)); // returns result in new instance (a is not changed = immutable)
a = new BigDecimal(5); // ok, 'a' is not final = can be change to refer to other BigDecimal instance)

final BigDecimal b = new BigDecimal(1);
BigDecimal c = b.add(new BigDecimal(2)); // // returns result in new instance (a is not changed = immutable)
b = new BigDecimal(5); // NOT OK!!!, 'b' is final = can not be changed to refer to other object