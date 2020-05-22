public <T> SessionResult<T> test() {

    return null;
}

public void blah() {
    if(test() instanceof SessionResult.NoSession$) {
    }
}