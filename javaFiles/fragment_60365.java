private void handleCanNotConnect(final Throwable cause) {
    isConnected = false;
    fireAll(new MyConsumer() {
        @Override
        public void accept(MyListener l) {
            l.connectionFailed(cause);
        }
    });
}

private void fireAll(MyConsumer action){
    action.accept(listener);
}