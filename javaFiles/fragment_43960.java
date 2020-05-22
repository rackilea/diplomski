import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String source = "a = 3   b = 4   if b > a then b==b else c==c";
    TLexer lexer = new TLexer(new ANTLRStringStream(source));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    TWalker walker = new TWalker(new CommonTreeNodeStream(parser.parse().getTree()));
    Node root = walker.walk();
    System.out.println(root.eval());
  }
}

interface Node {
  Object eval();
}

abstract class BinaryNode implements Node {

  protected Node left;
  protected Node right;

  public BinaryNode(Node l, Node r) {
    left = l;
    right = r;
  }
}

class AtomNode implements Node {

  private Object value;

  public AtomNode(Object v) {
    value = v;
  }

  @Override
  public Object eval() {
    return value;
  }
}

class OrNode extends BinaryNode {

  public OrNode(Node left, Node right) { super(left, right); }

  @Override
  public Object eval() {
    return (Boolean)super.left.eval() || (Boolean)super.right.eval();
  }
}

class AndNode extends BinaryNode {

  public AndNode(Node left, Node right) { super(left, right); }

  @Override
  public Object eval() {
    return (Boolean)super.left.eval() && (Boolean)super.right.eval();
  }
}

class LTNode extends BinaryNode {

  public LTNode(Node left, Node right) { super(left, right); }

  @Override
  public Object eval() {
    return (Double)super.left.eval() < (Double)super.right.eval();
  }
}

class LTEqNode extends BinaryNode {

  public LTEqNode(Node left, Node right) { super(left, right); }

  @Override
  public Object eval() {
    return (Double)super.left.eval() <= (Double)super.right.eval();
  }
}

class GTNode extends BinaryNode {

  public GTNode(Node left, Node right) { super(left, right); }

  @Override
  public Object eval() {
    return (Double)super.left.eval() > (Double)super.right.eval();
  }
}

class GTEqNode extends BinaryNode {

  public GTEqNode(Node left, Node right) { super(left, right); }

  @Override
  public Object eval() {
    return (Double)super.left.eval() >= (Double)super.right.eval();
  }
}

class EqNode extends BinaryNode {

  public EqNode(Node left, Node right) { super(left, right); }

  @Override
  public Object eval() {
    return super.left.eval().equals(super.right.eval());
  }
}

class NEqNode extends BinaryNode {

  public NEqNode(Node left, Node right) { super(left, right); }

  @Override
  public Object eval() {
    return !super.left.eval().equals(super.right.eval());
  }
}

class VarNode implements Node {

  private java.util.Map<String, Object> memory;
  private String var;

  VarNode(java.util.Map<String, Object> m, String v) {
    memory = m;
    var = v;
  }

  @Override
  public Object eval() {
    Object value = memory.get(var);
    if(value == null) {
      throw new RuntimeException("Unknown variable: " + var);
    }
    return value;
  }
}

class IfNode implements Node {

  private Node test;
  private Node ifTrue;
  private Node ifFalse;

  public IfNode(Node a, Node b, Node c) {
    test = a;
    ifTrue = b;
    ifFalse = c;
  }

  @Override
  public Object eval() {
    return (Boolean)test.eval() ? ifTrue.eval() : ifFalse.eval();
  }
}