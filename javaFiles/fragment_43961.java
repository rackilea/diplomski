tree grammar TWalker;

options {
  tokenVocab=T;
  ASTLabelType=CommonTree;
}

@members {
  private java.util.Map<String, Object> memory = new java.util.HashMap<String, Object>();
}

walk returns [Node n]
  :  (statement {$n = $statement.n;})+
  ;

statement returns [Node n]
  :  ifStatement {$n = $ifStatement.n;}
  |  assignment  {$n = null;}
  ;

assignment
  :  ^(ASSIGNMENT ID expression) {memory.put($ID.text, $expression.n.eval());}
  ;

ifStatement returns [Node n]
  :  ^(IF a=expression b=expression c=expression?) {$n = new IfNode($a.n, $b.n, $c.n);}
  ;

expression returns [Node n]
  :  ^(OR a=expression b=expression)   {$n = new OrNode($a.n, $b.n);}
  |  ^(AND a=expression b=expression)  {$n = new AndNode($a.n, $b.n);}
  |  ^('==' a=expression b=expression) {$n = new EqNode($a.n, $b.n);}
  |  ^('!=' a=expression b=expression) {$n = new NEqNode($a.n, $b.n);}
  |  ^('<=' a=expression b=expression) {$n = new LTEqNode($a.n, $b.n);}
  |  ^('<' a=expression b=expression)  {$n = new LTNode($a.n, $b.n);}
  |  ^('>=' a=expression b=expression) {$n = new GTEqNode($a.n, $b.n);}
  |  ^('>' a=expression b=expression)  {$n = new GTNode($a.n, $b.n);}
  |  BOOLEAN                           {$n = new AtomNode(Boolean.valueOf($BOOLEAN.text));}
  |  NUMBER                            {$n = new AtomNode(Double.valueOf($NUMBER.text));}
  |  ID                                {$n = new VarNode(memory, $ID.text);}
  ;