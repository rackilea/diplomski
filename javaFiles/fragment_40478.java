abstract class Operation { // Basic operation class
    public final String token;
    abstract public double operate (double x, double y);
    protected Operation(String token) {this.token = token; }
}
class AddOp extends Operation {
    public AddOp() { super("+"); }
    public double operate (double x, double y) {
        return x+y;
    }
}