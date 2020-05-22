public static void main(String[] args) {
    Creator creator = new Creator();
    Consumer consumer = new Consumer(creator);

    creator.createMyObject();
    consumer.consume();
}