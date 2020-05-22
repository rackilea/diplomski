private boolean entailed = false;

public boolean hasEntailed(){
    return entailed;
}

public void exitSubConcept(Parser.SubConceptContext ctx) {
    OWLClassExpression first = stack.pop();
    OWLClassExpression second = stack.pop();
    OWLSubClassOfAxiom s = factory.getOWLSubClassOfAxiom(second, first);
    if(reasoner.isEntailed(s))
    {
        System.out.println(s.toString() + "is entailed");
        entailed = true;
    }
    else
    {
        System.out.println(s.toString() + "is NOT entailed");
        entailed = false;
    }
    super.exitSubConcept(ctx);
}