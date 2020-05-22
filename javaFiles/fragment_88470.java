final Map<String,Object> contextVariables =
                computeExpressionObjects(configuration, processingContext);

        EvaluationContext baseEvaluationContext =
                (EvaluationContext) processingContext.getContext().getVariables().
                        get(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME);

        if (baseEvaluationContext == null) {
            // Using a standard one as base: we are losing bean resolution and conversion service!!
            baseEvaluationContext = new StandardEvaluationContext();
        }