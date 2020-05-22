class AClass<ContentT extends AContent> {
    // Make protected so subclasses can access
    // (probably better via a protected get method)
    protected ContentT content;
    ...
}

class BClass extends AClass<BContent> {

    BClass(BContent content) {
        super(content);
    }

    @Override
    protected void print() {
        // Now if I wanted I could do things with BContent that aren't
        // possible with AContent since the type of BContent is known
        System.out.println("BClass content is "+ content.getValue());
    }
}