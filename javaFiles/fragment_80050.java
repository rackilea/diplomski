void greet(final String name) {
    new AsyncOperation<Object>() {
        @Override Object doIt() {
            System.out.println("Hello " + name + "!");
        }
    }.execute(null);
}