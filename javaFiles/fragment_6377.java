public class ExtendedModel : Model {
    private final Model wrapped;
    public ExtendedModel(Model model) { wrapped = model; }
    private int addedField = 123;
    // Methods of the Model that you did not change simply forward the calls:
    public void doSomething() { wrapped.doSomething(); }
    public int calculateSomething() { return wrapped.calculateSomething(); }
    // Extended methods do whatever you need them to do:
    public int getAddedField() {return addedField;}
    public void increment() {addedField++;}
}