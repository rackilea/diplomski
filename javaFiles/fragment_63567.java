function:
    ^(FUNCTION_TOK fcname=IDENTIFIER functionParameters[a_param_arraylist]*)
;

functionParameters [ArrayList arr] returns [Object sth]:
    ^(PARAM_TOK value=IDENTIFIER){ sth = $value.getText(); arr.add(sth);}
;