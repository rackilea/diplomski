String left = (1000 + 700) * (50 + 25);
String right = (10000 - 5000);

Calculable calc = new ExpressionBuilder(leftCondition).build();
double result1 = calc.calculate();

calc = new ExpressionBuilder(rightCondition).build();
double result2 = calc.calculate();

System.out.println(result1 + " ------------- " + result2);