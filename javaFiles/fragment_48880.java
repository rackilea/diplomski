class AClass {
    // Make protected so subclasses can access
    // (probably better via a protected get method)
    protected AContent content;
    ...
}

class BClass extends AClass {

    BClass(BContent content) {
        super(content);
    }

    @Override
    protected void print() {
        System.out.println("BClass content is "+ content.getValue());
    }
}