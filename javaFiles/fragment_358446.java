public CDAccount(Account cd) {
    super(cd);
    if(cd instanceof CDAccount) {
        this.maturityDate = ((CDAccount)cd).maturityDate;
        this.termOfCD=((CDAccount)cd).termOfCD;
    }
    else {
        this.maturityDate = null;
        this.termOfCD= null;
    }
}