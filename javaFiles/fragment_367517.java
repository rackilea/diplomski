abstract class YourClass {
    private HandlerInterface unexposedHandler;

    YourClass(HandlerInterface handler) {
        unexposedHandler = handler;
    }

    public Object methodIWantToExpose(){
        // ... 
        handler.methodIDontWantExposed();
        // ...
    }
}