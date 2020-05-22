interface Operation { // Basic operation class
    String getToken();
    double operate (double x, double y);
}
class AddOp implements Operation {
    public String getToken() {return "+"; }
    public double operate (double x, double y) {
        return x+y;
    }
}