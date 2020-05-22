public class Foo {  
    public Foo() {
        Bar.Builder barBuilder = new Bar.Builder();
        Bar bar = barBuilder.build();
    }
}


public class Bar{
    private Bar(..){

    }

    static class Builder{
        public Bar build(){
            return new Bar(..);
        }
    }
}