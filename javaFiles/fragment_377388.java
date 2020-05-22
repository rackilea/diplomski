Variable x = model.addVariable("x");
Expression expr = model.addExpression("objective");

// Add the x^2 term
expr.set(x, x, 1.0);

// Add the -8x term
expr.set(x, -8.0);

// THIS FIXES IT
expr.weight(1.0);

Result result = model.minimise();