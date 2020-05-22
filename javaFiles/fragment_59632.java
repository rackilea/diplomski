public class Name {
    private final String name; //added field

    public Name (String name) {    
        if (name == null || name.trim ().isEmpty ()) {
            throw new IllegalArgumentException ("Name was empty");
        }
        this.name = name;
    }
    //...
}