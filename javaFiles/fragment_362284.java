public class SomeClass implements SomeKindOfListener 
    private final ErrorHandler errorHandler;
    ... other fields ...

    public SomeClass(ErrorHandler errorHandler, ... other parameters ... ) {
        this.errorHandler = errorHandler;
        ...
    }

    public void listenerCallback(SomeEvent e) {
        try {
            ... do something that might fail ...
        }
        catch (SomeKindOfException e) {
            errorHandler.errorOccurred("trying to wiggle the widget", e);
        }
    }         
}