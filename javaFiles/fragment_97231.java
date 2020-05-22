Expression exp = new CompoundExpression(
    new PlusOperation(),
    new CompoundExpression(
        new DivisionOperation(),
        new CompoundExpression(
            new PlusOperation(), 
            new Number(2), 
            new Number(3)
        ),
        new Number(4)
    ), 
);