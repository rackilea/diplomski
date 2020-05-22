JexlEngine jexl = new JexlEngine(null, new NoStringCoercionArithmetic(), null, null);
jexl.setLenient(false);
jexl.setStrict(true); 
JexlContext jc = new MapContext();
Expression exp = jexl.createExpression("\"1\"+\"1\"");
System.out.println(exp.evaluate(jc)); // expected result "11"