//using the exception itself
final Box<YourException> e = new Box<>();
Files.list((Paths.get("/some/path"))).map((someVal) -> {

    try {
        //do work with 'someVal'
    } catch (YourException ex) {
        //handle error
        e.setVar(ex);
    }

});
if (e.getVar() != null) {
    throw e.getVar();
}

class Box<T> {
    private T var;
    public void setVar(T var) { this.var = var; }
    public T getVar() { return this.var; }
}