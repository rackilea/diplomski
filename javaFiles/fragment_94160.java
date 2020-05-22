class Outer {
    public static void main(String[] args) {
         Outer tmp = (Outer) null;
         Outer.Inner obj = new; //object created
         tmp."<init>"(tmp);
    }
}
class Outer$Inner {
    //generated field
    private final Outer outer;
    //generated initializer
    void "<init>"(Outer outer) {
         this.outer = outer;
    }    
}