public class StackOverflowQuestion {

    interface Example {

        <T extends Example> T init();
    }

    static class ExampleImpl implements Example {

        @Override
        public ExampleImpl init() {
            return this;
        }
    }

    static class ExampleImpl2 implements Example {

        @Override
        public <T extends Example> T init() {
            return null;
        }
    }

    public static void main(String[] args) {
        ExampleImpl2 e2 = ((Example) new ExampleImpl()).<ExampleImpl2>init();
    }
}