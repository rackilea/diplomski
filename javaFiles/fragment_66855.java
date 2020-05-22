enum Error {

    IS_NULL("The variable {%s} cannot be null.");

    public String errorMsg;

    private Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}