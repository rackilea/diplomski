final Multimap<Term, BooleanClause> terms = getTerms(bq);
        for (Term t : terms.keySet()) {
            Collection<BooleanClause> C = new HashSet(terms.get(t));
            if (!C.isEmpty()) {
                for (Iterator<BooleanClause> it = C.iterator(); it.hasNext();) {
                    BooleanClause c = it.next();
                    if(c.isSomething()) it.remove(); // <-- invoke remove on the Iterator. Removes the element returned by it.next.
                }
            }
        }