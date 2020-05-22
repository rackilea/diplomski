public class ThisEscape
{
    Foo foo;
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener()
        {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });

        // Possible Thread Context switch

        // More important initialization
        foo = new Foo();
    }

    public void doSomething(Event e) {
        // Might throw NullPointerException, by being invoked
        // through the EventListener before foo is initialized
        foo.bar();
    }
}