public interface SomeServiceInterface{  
    boolean isAsynchronous();

    ResponseObject someMethod();

    void addEventHandler(MyProcessEventHandler h);
}