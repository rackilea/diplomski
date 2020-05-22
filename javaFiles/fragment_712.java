Map<String, Object> funcs = new HashMap<String, Object>();
funcs.put(null, Math.class);
JexlEngine jexl = new JexlBuilder().namespaces(funcs).create();
JexlExpression je = jexl.createExpression("log(5)");
Object result = je.evaluate(null);
Assert.assertNotNull(result);