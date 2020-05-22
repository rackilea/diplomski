@Bean
public MyDecorator decoratedCache1() {
    return new MyDecorator(cache1);
}

@Bean
public MyDecorator decoratedCache2() {
    return new MyDecorator(cache2);
}