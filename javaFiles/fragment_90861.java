public class FooBar implements Foo, Bar{    
    @Override
    public void doThat() {
        Bar.super.doThat();
    }    
}