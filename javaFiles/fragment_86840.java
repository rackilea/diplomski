grammar AntlrFormula;

options {
    output = AST; 
}


program : formula ;

formula : atom | LEFT_PAREN! biconexpr RIGHT_PAREN! ;

biconexpr : impexpr (BICONDITIONAL^ impexpr)*;

impexpr : orexpr (IMPLICATION^ orexpr)*;

orexpr : andexpr (DISJUNCTION^ andexpr)*;

andexpr : notexpr (CONJUNCTION^ notexpr)*;

notexpr : (NEGATION^)? formula;


atom
    : CHAR
    | TRUTH
    | FALSITY
    ;


// Atoms
CHAR: 'a'..'z';
TRUTH: ('\u22A4' | 'T');
FALSITY: ('\u22A5' | 'F');

// Grouping
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
NEGATION: ('\u00AC' | '~' | '!');
CONJUNCTION: ('\u2227' | '&' | '^');
DISJUNCTION: ('\u2228' | '|' | 'V');
IMPLICATION: ('\u2192' | '->');
BICONDITIONAL: ('\u2194' | '<->');

WHITESPACE : (' ' | '\t' | '\r' | '\n') { $channel = HIDDEN; };