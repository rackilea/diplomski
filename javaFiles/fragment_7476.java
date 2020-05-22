private <A, R> R foo(A arg) {
    if (arg != null) {
        // TODO: Use injection or a map to create a relation between Class<A> and its Invokable<A, R>.
        final Invokable<A, R> invokable = invokables.get(a.getClass());
        try {
            return invokable.invoke(arg); // Type checked result (R).
        } catch (InterruptedException e) {
            // TODO: Handle exception.
        }
    }
    return null;
}