class UserValidator {
    public static enum ValidatorState { NOT_RUN, PASSED, FAILED }
    private ValidatorState state = NOT_RUN;
    private final Request request;
    private final Response response;
    public UserValidator(Request request, Response response) {
        this.request = request;
        this.response = response;
    }
    public ValidatorState validate() {
        if(state != NOT_RUN) return state;
        if(blah blah)
            state = PASSED;
        else
            state = FAILED;
        return state;
    }
}