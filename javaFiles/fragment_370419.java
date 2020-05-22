grammar test01;

options {
    output=AST; 
}

test:
  id ('|' id)* -> id (BR id)*;

id
@init{
  int N = 0;
}
  : {N++;} ID  -> {new CommonTree(new CommonToken(ID, Integer.toString(N) + " : "  + $ID.text))}
  ;

// other rules