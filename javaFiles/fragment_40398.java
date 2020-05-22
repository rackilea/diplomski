public static int reduceWithCancelEx(IntStream stream, int identity, 
                      IntBinaryOperator combiner, IntPredicate cancelCondition) {
    class CancelException extends RuntimeException {
        private final int val;

        CancelException(int val) {
            this.val = val;
        }
    }

    try {
        return stream.reduce(identity, (a, b) -> {
            int res = combiner.applyAsInt(a, b);
            if(cancelCondition.test(res))
                throw new CancelException(res);
            return res;
        });
    } catch (CancelException e) {
        return e.val;
    }
}