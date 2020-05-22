public class ExpressionEvaluatingRouter extends AbstractMessageProcessingRouter {

    public ExpressionEvaluatingRouter(Expression expression) {
        super(new ExpressionEvaluatingMessageProcessor<Object>(expression));
        setPrimaryExpression(expression);
    }

}