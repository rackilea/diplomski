import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;
import java.util.*;

public class Main {

  static Map<String, List<B>> getData() {
    Map<String, List<B>> map = new HashMap<String, List<B>>();
    List<B> data = new ArrayList<B>();
    data.add(new B("id_1", 345, "89", "abd"));
    data.add(new B("id_2", 45, "89", "abd"));
    data.add(new B("id_3", 1, "89", "abd"));
    data.add(new B("id_4", 45, "8", "abd"));
    data.add(new B("id_5", 45, "89", "abc"));
    data.add(new B("id_6", 45, "99", "abC"));
    map.put("poolX", data);
    return map;
  }

  public static void main(String[] args) throws Exception {
    String src = "select C, Y from poolX where X = 45 AND Y > '88' AND Z != 'abc';";
    SelectLexer lexer = new SelectLexer(new ANTLRStringStream(src));
    SelectParser parser = new SelectParser(new CommonTokenStream(lexer));
    CommonTree tree = (CommonTree)parser.parse().getTree();  
    SelectWalker walker = new SelectWalker(new CommonTreeNodeStream(tree), getData());  
    List<List<Object>> result = walker.query();
    for(List<Object> row : result) {
      System.out.println(row);
    }
  }
}

class B {

  String C;
  Integer X;
  String Y;
  String Z;

  B(String c, Integer x, String y, String z) {
    C = c;
    X = x;
    Y = y;
    Z = z;
  }

  Object getAttribute(String attribute) {
    if(attribute.equals("C")) return C;
    if(attribute.equals("X")) return X;
    if(attribute.equals("Y")) return Y;
    if(attribute.equals("Z")) return Z;
    throw new RuntimeException("Unknown attribute: B." + attribute);
    // or use your Apache Bean-util API, or even reflection here instead of the above...
  }
}

interface Node {
  Object eval(B b);
}

class AtomNode implements Node {

  final Object value;

  AtomNode(Object v) {
    value = v;
  }

  public Object eval(B b) {
    return value;
  }
}

abstract class BinNode implements Node {

  final Node left;
  final Node right;

  BinNode(Node l, Node r) {
    left = l;
    right = r;
  }

  public abstract Object eval(B b);
}

class AndNode extends BinNode {

  AndNode(Node l, Node r) {
    super(l, r);
  }

  @Override
  public Object eval(B b) {
    return (Boolean)super.left.eval(b) && (Boolean)super.right.eval(b);
  }
}

class EqNode extends BinNode {

  EqNode(Node l, Node r) {
    super(l, r);
  }

  @Override
  public Object eval(B b) {
    return super.left.eval(b).equals(super.right.eval(b));
  }
}

class NEqNode extends BinNode {

  NEqNode(Node l, Node r) {
    super(l, r);
  }

  @Override
  public Object eval(B b) {
    return !super.left.eval(b).equals(super.right.eval(b));
  }
}

class GTNode extends BinNode {

  GTNode(Node l, Node r) {
    super(l, r);
  }

  @Override
  public Object eval(B b) {
    return ((Comparable)super.left.eval(b)).compareTo((Comparable)super.right.eval(b)) > 0;
  }
}

class IdNode implements Node {

  final String id;

  IdNode(String i) {
    id = i;
  }

  @Override
  public Object eval(B b) {
    return b.getAttribute(id);
  }
}

class SelectNode implements Node {

  final List<String> attributes;
  final List<B> data;
  final Node expression;

  SelectNode(List<String> a, List<B> d, Node e) {
    attributes = a;
    data = d;
    expression = e;
  }

  @Override
  public Object eval(B ignored) {
    List<List<Object>> result = new ArrayList<List<Object>>();
    for(B b : data) {
      if((Boolean)expression.eval(b)) {
        // 'b' passed, check which attributes to include
        List<Object> row = new ArrayList<Object>();
        for(String attr : attributes) {
          row.add(b.getAttribute(attr));
        }
        result.add(row);
      }
    }
    return result;
  }
}