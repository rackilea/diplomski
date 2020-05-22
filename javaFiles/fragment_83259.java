RatioFunctionExpression ratioFunctionExpression = null;
RatioFunctionExpressionId ratioFunctionExpressionId = null;
try {
    ratioFunctionExpression = new RatioFunctionExpression();

    List<Object> params = new ArrayList<Object>();
    params.add(ratioFunctionId);
    params.add(expressionId);

    List<RatioFunctionExpression> instance
        = (List<RatioFunctionExpression>) template.find("from RatioFunctionExpression ratioFunctionExpression where ratioFunctionExpression.id.ratioFunctionId = ? and ratioFunctionExpression.id.expressionId = ?",
                                                        params.toArray());
    logger.debug("get successful");
    if (instance.size() > 0) {
        ratioFunctionExpression = instance.get(0);
    } else {
        logger.debug("Lookup of id [" + expressionId + "] is not found in RatioFunctionExpression table");
    }