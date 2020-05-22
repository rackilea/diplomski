ExpressionFactory factory = new ExpressionFactoryImpl();

// create a context and add a Person object to the context, this variable will be used
// in the property replacement
// objects of type Person have two fields: firstName and lastName

SimpleContext context = new SimpleContext();
Person person = new Person("John", "Doe");
context.setVariable("person", factory.createValueExpression(person, Person.class));

// create the expression

String expr = "My name is ${person.firstName} ${person.lastName}";
ValueExpression e = factory.createValueExpression(context, expr, String.class);

// evaluate the expression
System.out.println(e.getValue(context));