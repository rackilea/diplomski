NumberBinding circleRippleRadius =
    Bindings.max(widthProperty(), heightProperty());

// Optional
DoubleExpression circleRippleRadiusAsDouble =
    DoubleExpression.doubleExpression(circleRippleRadius);