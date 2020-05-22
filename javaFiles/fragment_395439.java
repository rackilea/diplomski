public aspect Processor {

    private StaticReference z;

    pointcut generic()
            // intercept execution of method named test, annotated with @Anno1
            // from any class type, annotated with @Anno2
        : execution(@Anno2 * (@Anno1 *).test())
            // method takes no arguments
        && args ();

    // here you have write what you want method actually does
    void around () : generic()  {
        z.invokeToAll();
    }


}