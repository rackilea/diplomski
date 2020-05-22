public void setup() {
    this.operations.add(new Operation(new RequestA(), new CallbackA()));
    this.operations.add(new Operation(new RequestB(), new CallbackB()));
    this.operations.add(new Operation(new RequestC(), new CallbackC()));
    this.operations.add(new Operation(new RequestD(), new CallbackD()));
    startNextOperation();
}
private void startNextOperation() {
    if ( this.operations.isEmpty() ) { reportAllOperationsComplete(); }
    Operation op = this.operations.remove(0);
    op.request.go( op.callback );
}
private class CallbackA implements Callback<Boolean> {
    public void onSuccess(Boolean response) {
        // store response? etc?
        startNextOperation();
    }
}
...