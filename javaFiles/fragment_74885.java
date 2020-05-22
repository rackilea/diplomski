// Function of 1 variable, keep track of 3 derivatives with respect to that variable,
// use 2.5 as the current value.  Basically, the identity function.
DerivativeStructure x = new DerivativeStructure(1, 3, 0, 2.5);
// Basically, x --> x^2.
DerivativeStructure x2 = x.pow(2);
//Linear combination: y = 4x^2 + 2x
DerivativeStructure y = new DerivativeStructure(4.0, x2, 2.0, x);
System.out.println("y    = " + y.getValue());
System.out.println("y'   = " + y.getPartialDerivative(1));
System.out.println("y''  = " + y.getPartialDerivative(2));
System.out.println("y''' = " + y.getPartialDerivative(3));