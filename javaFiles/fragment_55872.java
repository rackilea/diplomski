NumericPoint<Integer> ip1 =
    new NumericPoint<Integer>(new MyInt(1), new MyInt(2));
NumericPoint<Integer> ip2 =
    new NumericPoint<Integer>(new MyInt(3), new MyInt(4));
NumericPoint<Integer> ip = ip1.add(ip2);
System.out.println(ip);

NumericPoint<Double> dp1 = 
  new NumericPoint<Double>(new MyDouble(1.1), new MyDouble(2.1));
NumericPoint<Double> dp2 = 
  new NumericPoint<Double>(new MyDouble(3.1), new MyDouble(4.1));
NumericPoint<Double> dp = dp1.add(dp2);
System.out.println(dp);