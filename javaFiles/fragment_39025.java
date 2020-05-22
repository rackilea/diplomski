public class ListenerClass {

    void onFoo(Foo foo){}
    void onBar(Bar bar){}

    static class FooListener implements ApplicationListener<Foo> {
       ListenerClass listerner;
       ....
       public void onApplicationEvent(Foo foo) {
           listener.onFoo(foo);
       }
    }
    static class BarListener implements ApplicationListener<Bar> {
       ListenerClass listerner;
       ....
       public void onApplicationEvent(Bar bar) {
           listener.onBar(bar);
       }
    }
}