public class TwoTypesConsumer {
    private TomatoConsumer tomatoConsumer = new TomatoConsumer();
    private AppleConsumer appleConsumer = new AppleConsumer();

    public void consume(Tomato t) { 
        tomatoConsumer.consume(t);
    }

    public void consume(Apple a) { 
        appleConsumer.consume(a);
    }

    public static class TomatoConsumer implements Consumer<Tomato> {
        public void consume(Tomato t) {  .....  }
    }

    public static class AppleConsumer implements Consumer<Apple> {
        public void consume(Apple a) {  .....  }
    }
}