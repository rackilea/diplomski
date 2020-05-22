final ExpressionParser parser = new SpelExpressionParser();
StandardEvaluationContext context = new StandardEvaluationContext();
context.setBeanResolver(new BeanFactoryResolver(beanFactory));
context.addPropertyAccessor(new BeanExpressionContextAccessor());
Expression expression = parser.parseExpression("someOtherBean.getData()");
BeanExpressionContext rootObject = new BeanExpressionContext(beanFactory, null);

...

String value = expression.getValue(context, rootObject, String.class);