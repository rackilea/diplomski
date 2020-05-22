Expression terms = new Or(
    new And(new Term("a", ...), new Term("b", ...)), 
    new And(new Term("c", ...), 
        new And(new Term("d", ...), new Not(new Term("e", ...))
    )
);
boolean value = terms.evaluate();