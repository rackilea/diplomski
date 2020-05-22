public class Test{
    public static void main(String[] args){
        DerivedNode dn = new DerivedNode();
        Derived d = new Derived(dn);
        d.bar( dn );
    }
}

class Base{
    protected BaseNode n;
    public Base(BaseNode _n){
        this.n = _n;
    }

    public void foo(BaseNode x){
        n.foo(x);
    }
}


class BaseNode{
    public void foo(BaseNode x){
        System.out.println( "BaseNode foo" );
    }
}

class Derived extends Base{
    public Derived(BaseNode n){
        super(n);
    }

    public void bar(DerivedNode x){
        if( n instanceof DerivedNode ){
            // Type cast to DerivedNode to access bar
            ((DerivedNode)n).bar(x);
        }
        else {
            // Throw exception or what ever
            throw new RuntimeException("Invalid Object Type");
        }
    }
}

class DerivedNode extends BaseNode{
    public void bar(BaseNode b){
        System.out.println( "DerivedNode bar" );
    }
}