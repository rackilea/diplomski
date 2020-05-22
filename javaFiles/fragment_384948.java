tree grammar SelectWalker;

options {
  tokenVocab=Select;
  ASTLabelType=CommonTree;
}

@header {
  import java.util.List;
  import java.util.Map;
  import java.util.Set;
}

@members {

  private Map<String, List<B>> dataPool;

  public SelectWalker(CommonTreeNodeStream nodes, Map<String, List<B>> data) {
    super(nodes);
    dataPool = data;
  }
}

query returns [List<List<Object>> result]
 : ^(ROOT select_stat) {$result = (List<List<Object>>)$select_stat.node.eval(null);}
 ;

select_stat returns [Node node]
 : ^(Select attr_list Id expr) 
    {$node = new SelectNode($attr_list.attributes, dataPool.get($Id.text), $expr.node);}
 ;

attr_list returns [List<String> attributes]
@init{$attributes = new ArrayList<String>();}
 : ^(ATTR_LIST (Id {$attributes.add($Id.text);})+)
 ;

expr returns [Node node]
 : ^(Or a=expr b=expr)   {$node = null; /* TODO */}
 | ^(And a=expr b=expr)  {$node = new AndNode($a.node, $b.node);}
 | ^(Eq a=expr b=expr)   {$node = new EqNode($a.node, $b.node);}
 | ^(NEq a=expr b=expr)  {$node = new NEqNode($a.node, $b.node);}
 | ^(LT a=expr b=expr)   {$node = null; /* TODO */}
 | ^(LTEq a=expr b=expr) {$node = null; /* TODO */}
 | ^(GT a=expr b=expr)   {$node = new GTNode($a.node, $b.node);}
 | ^(GTEq a=expr b=expr) {$node = null; /* TODO */}
 | ^(UNARY_MINUS a=expr) {$node = null; /* TODO */}
 | ^(Not a=expr)         {$node = null; /* TODO */}
 | Str                   {$node = new AtomNode($Str.text);}
 | Int                   {$node = new AtomNode(Integer.valueOf($Int.text));}
 | Id                    {$node = new IdNode($Id.text);}
 ;