testcase :
     singletest
     ( Linebreak singletest) *
     ;

singletest:
        'ruleA' ':' ruleA 
      | 'ruleB' ':' ruleB 
      |...
      ;


Whitespace: [ \t] -> skip; // no line break!
Linebreak: '\r\n' | '\r' | '\n';