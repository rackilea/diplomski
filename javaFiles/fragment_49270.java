public class Foo {
    private Map<String, Bar> barDictionary;

    public Foo() {
        this.barDictionary = new HashMap<String, Bar>();
    }

    public Foo(Foo f) { 
        // What happens here is up to you.  I'd recommend making a deep copy in this case.
        this.barDictionary = new HashMap<String, Bar>(); 
        this.barDictionary.putAll(f.barDictionary);  // Question: What about the Bar references?  What happens to those?
    }
}