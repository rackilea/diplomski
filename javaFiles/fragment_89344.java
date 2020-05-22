import org.apache.commons.jexl3.*;

JexlEngine jexl = new JexlBuilder().create();
String expression = "(a|b)^c";
JexlExpression jExpression = jexl.createExpression(expression);

// JexlContext stores the values for variables used in an JexlExpression
JexlContext context = new MapContext();
context.set("a", true);
context.set("b", true);
context.set("c", true);

// evaluate expression.
Long result = (Long) jExpression.evaluate(context);
System.out.println(result); // 0 for false