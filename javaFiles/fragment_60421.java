EvaluateExpressionRequest evaluateExpressionRequest = new EvaluateExpressionRequest()
                .withPipelineId(myPipelineId)
                .withExpression(expressionToBeEvaluated)
                .withObjectId(myPipelineObjectId);

dataPipeline.evaluateExpression(evaluateExpressionRequest).getEvaluatedExpression(); //evaluates to sometext-20180826010000