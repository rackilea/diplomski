ECCurve curve = //...
ECFieldElement x = //...
ECFieldElement y = //...

ECFieldElement a = curve.getA();
ECFieldElement b = curve.getB();
ECFieldElement lhs = y.multiply(y);
ECFieldElement rhs = x.multiply(x).multiply(x).add(a.multiply(x)).add(b);

boolean pointIsOnCurve = lhs.equals(rhs);