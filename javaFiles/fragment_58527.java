service.getResult(createRequestObject(), new AsyncCallback<String>() {
    public void onSuccess(final String returnedValue) {
        doSomethingWithString(returnedValue);
    }
    // onFail etc.
});