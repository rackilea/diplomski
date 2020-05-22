doTest(String.class);
}
private static void doTest(Class<? extends Comparable> type) {
    doSomething(type, "test"); 

}
// third party API like javax.swing.event.EventListenerList.add()
private static <C extends Comparable> void doSomething(Class<C> ct, Comparable c) {
    // ...
}