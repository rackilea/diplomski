public Result action() {
    return ok(new StringChunks() {
        public void onReady(final Out<String> out) {
            out.onDisconnected(new F.Callback0() {
                public void invoke() throws Throwable {
                    // clean up things ...
                }
            }
            openStream().onData(new Consumer<String>() {
                public void accept(String string) {
                    out.write(string);
                }
            }
        }
    }
}