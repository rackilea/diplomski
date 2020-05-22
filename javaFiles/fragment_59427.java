private Balance createBalance(Value v, String type, String currency, String balance) {
    CurAmt curAmt = new CurAmt();
    Balance bal = new Balance();
    bal.setBalType(type);
    curAmt.setCurCode(value.getAs(currency));
    curAmt.setContent(value.getAs(ballance));
    bal.setCurAmt(curAmt);
    return bal;
}