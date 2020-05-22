final LU<Double> tmpLU = LU.PRIMITIVE.make();
    tmpLU.decompose(A);
    if (tmpLU.isSquareAndNotSingular()) {
        x = tmpLU.solve(b);
    } else {
        // Do something else...
    }