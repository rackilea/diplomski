public class TwoTypesConsumer {
    private Consumer<Tomato> tomatoConsumer = new Consumer<Tomato>() {
        public void consume(Tomato t) {
        }
    };

    private Consumer<Apple> appleConsumer = new Consumer<Apple>() {
        public void consume(Apple a) {
        }
    };

    public void consume(Tomato t) {
        tomatoConsumer.consume(t);
    }

    public void consume(Apple a) {
        appleConsumer.consume(a);
    }
}