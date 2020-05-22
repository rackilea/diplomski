private static ThreadLocal<Boolean> dontIntercept = new ThreadLocal<Boolean>() {

    @Override
    protected Boolean initialValue() {
        return Boolean.FALSE;
    }

};