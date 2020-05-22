publi class CommonResponseObject {
    private OKObject okObject;
    private ErrorObject errorObject;
    public CommonResponseObject(OKObject okObject) {
        this.okObject=okObject;
    }
    public CommonResponseObject(ErrorObject errorObject) {
        this.errorObject=errorObject;
    }
}