package tl.tree;

import tl.TLValue;
import java.util.ArrayList;
import java.util.List;

public class MathCallNode implements TLNode {

    private String methodName;
    private List<TLNode> params;

    public MathCallNode(String nm, List<TLNode> ps) {
        methodName = nm;
        params = ps;
    }

    @Override
    public TLValue evaluate() {
        if(methodName.equals("sqrt")) 
            return new TLValue(Math.sqrt(params.get(0).evaluate().asDouble()));
        else if(methodName.equals("min")) 
            return new TLValue(Math.min(params.get(0).evaluate().asDouble(), params.get(1).evaluate().asDouble()));  
        // TODO implement more Math-methods
        else
            throw new RuntimeException("unknown method: Math." + methodName + "(...)");
    }
}