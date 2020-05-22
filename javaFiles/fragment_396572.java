public abstract class Foo<T extends Foo<T>> {

    public List<T> container;

    protected Foo() {
        enforceConstraints();
    }

    private void enforceConstraints() {
        boolean valid = true;
        try {
            valid =
                ((ParameterizedType) this.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0]
                    .equals(
                        this.getClass()
                    );
        } catch (ClassCastException cce) {
            valid = false;
        }
        if (!valid) {
            String name = this.getClass().getSimpleName();
            throw new IllegalImplementationException(
                    name + " must be declared as "+ "\"class " + name + " extends Foo<"+name+">\"");
        }
    }

    private static class IllegalImplementationException extends RuntimeException {
        IllegalImplementationException(String message) {
            super(message);
        }
    }
}