context.setVariable("fii", factory.createValueExpression(new BigDecimal(3), BigDecimal.class));
context.setVariable("fee", factory.createValueExpression(new BigDecimal(5), BigDecimal.class));

ValueExpression e1 = factory.createValueExpression(context, "${fee}", BigDecimal.class);
ValueExpression e2 = factory.createValueExpression(context, "${fii}", BigDecimal.class);

String temp1 = (String)e1.getValue(context).toString();
String temp2 = (String)e2.getValue(context).toString();

context.setVariable("foo", factory.createValueExpression(new BigDecimal(temp1).add(new BigDecimal(temp2)), BigDecimal.class));

ValueExpression e = factory.createValueExpression(context, "${foo}", BigDecimal.class);// will return 8