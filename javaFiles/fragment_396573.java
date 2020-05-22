public class Foo<T> where T : Foo<T> {

    public List<T> container;

    protected Foo() {
        enforceConstraints();
    }

    private void enforceConstraints() {
        if (!this.GetType().Equals(typeof(T))) {
            String name = this.GetType().Name;      
            throw new IllegalImplementationException(
                name + " must be declared as " + "\"class " + name + " : Foo<" + name + ">\"");
        }
    }


}

public class IllegalImplementationException : Exception {
    public IllegalImplementationException(String message) : base(message) {}
}