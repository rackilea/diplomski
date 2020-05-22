public class MathemeaticalObject<N extends Number> {
    private final NumberOperations<N> ops;
    public MatchematicalObject(NumberOperations<N> ops) {
        this.ops = ops;
    }

    public N myComplexOperation(N other) {
        return ops.add(this, other);
    }
}

public class MathematicalObjectFactory {
    MathematicalObject<Integer> integerObject() {
        return new MathematicalObject(new IntegerOperations());
    }
    ....
}

public interface NumberOperations<N extends Number> {
    N add(N other);
}

public class IntegerOperations implements NumberOperations<Integer> {
    @Override
    public Integer add(Integer first, Integer second) {
        return first + second;
    }
}