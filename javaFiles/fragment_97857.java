public ArrayList<PolyTerm> terms;

public Poly(ArrayList<PolyTerm> terms)
 {
sort(terms);
this.terms = terms;
condenseExponents();
}