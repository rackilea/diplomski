public abstract class Example {
    public void methodOne() {
        //Inherited
    }
    public void methodTwo() {
        //Interited
        //Maybe calls methodThree() as a part of its function
    }
    public abstract void methodThree();
}
...
static void main(String[] args) {
    Example e = new Example() {
        @Override
        public void methodThree() {
            ... // Do something
        }
    };
}