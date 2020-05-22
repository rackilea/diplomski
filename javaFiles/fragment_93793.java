final CountDownLatch stopLatch = new CountDownLatch(1);

reactor.on($(topic), new Consumer<Event<Message>>(){

    @Override
    public void accept(Event<Message> t) {
        System.out.println("Hello World");
        stopLatch.countDown();
    }

});
....
stopLatch.await();