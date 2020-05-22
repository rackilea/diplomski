public void callFromJavaScript(final String param) {
    AccessController.doPrivileged( new PrivilegedAction<Void>() {
        public Void run() {
            // call code to make the connection..
            return null;
        }
    });
}