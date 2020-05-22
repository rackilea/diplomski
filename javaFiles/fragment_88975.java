import java.util.*;

interface OBJ {
    String accept(ObjVisitor v);
}

interface ObjVisitor {
    String visit(X x);
    String visit(Y y);
    String visit(Z z);
}

class X implements OBJ {
    public String accept(ObjVisitor v){ return v.visit(this); }
}
class Y implements OBJ {
    public String accept(ObjVisitor v) { return v.visit(this); }
}
class Z implements OBJ {
    public String accept(ObjVisitor v) { return v.visit(this); }
}