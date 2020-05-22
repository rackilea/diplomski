System.out.print("x: ");
x = scan.nextDouble();
System.out.print("y: ");
y  = scan.nextDouble();

num = Math.cbrt( ((2 * Math.pow(x,4) * y) + (2 * x * Math.pow(y,4) )) );
den = (4 * x * Math.pow(y, ((2 * x) + (2 * y))));

ans = num / den;
System.out.println("\n The answer is " + ans);