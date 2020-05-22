/**
 * Validates a term before it is added to a Polynomial.
 * @param coef must not be 0
 * @param deg must be nonnegative
 * @param term term to return
 * @return term if valid coefficient and degree, null otherwise
 */
private Term validatedTerm(double coef, int deg, Term term) {
    Term temp = new Term();
    if(!temp.setData(coef, deg) || !temp.setLink(term))
        return null;
    return temp;
}

/**
 * Adds a term to the start of the Polynomial. Uses Term validatedTerm(double, int, Term)<br />
 * Will not add term if not validated.
 * @param coef coefficient of term
 * @param deg degree of term
 */
public void addToStart(double coef, int deg) {
    Term term;
    if((term = validatedTerm(coef, deg, null)) == null)
        return;

    if(head != null)
        term.setLink(head);     
    else
        tail = term;

    head = term;
    numTerms++;
}