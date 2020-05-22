enum TokType {
    FIRST,
    OPERAND,
    OPERATOR,
    LPAREN,
    RPAREN,
}

boolean shouldMultBeEmitted(TokType tt)
{
    return tt == TokType.OPERAND || tt == TokType.RPAREN;
}

public ArrayList<String> tokenize(String in)
{
    TokType prevTok = TokType.FIRST; /* keep track of the type of the prev. tok, so
                                        we know when to insert a mult. sign */

    String regex = "(?<=[-−+*/()])|(?=[-−+*/()])";
    String toks[] = in.split(regex);

    /* the string has been tokenized; insert any needed multiplication signs */
    ArrayList<String> ret = new ArrayList<>();

    for (String x : toks) {
        if (isNumeric(x) || x.equals("Ans") || x.equals("π")) {
            if (shouldMultBeEmitted(prevTok))
                ret.add("*");

            prevTok = TokType.OPERAND;
        }
        else if (x.equals(LPAREN)) {
            if (shouldMultBeEmitted(prevTok))
                ret.add("*");

            prevTok = TokType.LPAREN;
        }
        else if (x.equals(RPAREN))
            prevTok = TokType.RPAREN;
        else if (isOperator(x))
            prevTok = TokType.OPERATOR;

        ret.add(x);
    }
    return ret;
}