public SessionResult<Nothing$> test() {

    return null;
}

public void blah() {
    if(test() instanceof SessionResult.NoSession$) {
    }
}