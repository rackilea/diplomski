service.getResult(createRequestObject(), new AsyncCallback() {
    public void onSuccess(final Object returnedValue) {
        doSomethingWith(returnedValue);
    }
    public void onFailure(Throwable caught) {
        // code for the call failing (alert, log...)
    }
});