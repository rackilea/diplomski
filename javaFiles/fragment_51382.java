label_23: while (true) {
    if (jj_2_17(2)) {
        ;
    } else {
        break label_23;
    }
    jj_consume_token(DOT);
    jj_consume_token(IDENTIFIER);
    ret = new QualifiedNameExpr(ret.getBeginLine(), ret.getBeginColumn(), token.endLine, token.endColumn, ret, token.image);
}