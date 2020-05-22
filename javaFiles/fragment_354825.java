public final <T extends ReturnInterface<?>> void // this is how you name and bind the type
   submitCallable(Callable<T> c) { // here you are referring to it
    // create a map for this future
    ecs.submit((Callable<ReturnInterface<?>>) c); // here you need to cast. 
    ...
}