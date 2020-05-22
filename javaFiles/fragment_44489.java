Observable<Shape> produceShapes(int amount) {
    System.out.println("Produced following shapes:");
    return Observable.range(1, amount)
            .map(index -> Shape.getShape())
            .doOnNext(System.out::print);
}