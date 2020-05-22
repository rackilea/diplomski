@Service
public class MySecurityExpressionHandler extends
    DefaultMethodSecurityExpressionHandler {

    @Override
    public StandardEvaluationContext createEvaluationContextInternal(
        Authentication auth, MethodInvocation mi) {

    StandardEvaluationContext evaluationContext = super
            .createEvaluationContextInternal(auth, mi);

    SomeMethodInfoData methodInfoData = mi.getMethod(). ...;

    evaluationContext.setVariable("someData", <value computed based on method info data>);
    }

    return evaluationContext;
}