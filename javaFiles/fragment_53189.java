public static void main(String[] args) {
    Stream<Double> orgStream = Stream.of(1.0, 3.0, 7.0, 2.0, 9.0);

    MyStream<Double> myStream = new MyStream<>(orgStream);

    myStream.biggerThanFour().forEach(System.out::println);
}