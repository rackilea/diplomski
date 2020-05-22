Variable X = new Variable("X");

Term t = Util.textToTerm("[Bar]");

Query q4 =
    new Query(
        "searchEventsOnCategory",
        new Term[] {t,X}
        );