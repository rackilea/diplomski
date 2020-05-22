class RunnableList {

    private List<Invocable<?>> invocables = new ArrayList<Invocable<?>>();

    public <T> void add(T target, Consumer<T> invocation) {
        invocables.add(new Invocable<T>(target, invocation));
    }

    public void run() {
        invocables.forEach(Invocable::runInvocation);
    }
}