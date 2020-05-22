public interface Action<T>
{
    void execute(T item);
}

private static Map<String, Action<Foo>> getActions()
{
    Action<Foo> firstAction = new Action<Foo>() {
        @Override public void execute(Foo item) {
             // Insert implementation here
        }
    };
    Action<Foo> secondAction = new Action<Foo>() {
        @Override public void execute(Foo item) {
             // Insert implementation here
        }
    };
    Action<Foo> thirdAction = new Action<Foo>() {
        @Override public void execute(Foo item) {
             // Insert implementation here
        }
    };
    Map<String, Action<Foo>> actions = new HashMap<String, Action<Foo>>();
    actions.put("first", firstAction);
    actions.put("second", secondAction);
    actions.put("third", thirdAction);
    return actions;
}