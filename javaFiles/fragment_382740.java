DistFormula newFormula = new DistFormula();
newFormula.setX1(10.1);
newFormula.setY1(18.2);
newFormula.setX2(12.9);
newFormula.setY2(17.5);

double answer=newFormula.calculate();
System.out.println("Distance between coordinates: " + answer);