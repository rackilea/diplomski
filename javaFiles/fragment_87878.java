public class MyPublicClass {

    private class MyPrivateClass {
        public void doPublicMethod() {}
    }

    private class Test extends MyPrivateClass {
        @Override
        public void doPublicMethod() {
            // Do your stuff
        }
    }
}