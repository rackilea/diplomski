(args: Tuple2<ActorRef, Object>) -> {
    Object msg = args._2();
    if (msg instanceof String) {
        log.info("received msg, queueing: {} ", msg);
        messages = messages.enqueue((String) msg);
        pump();
    }
    return BoxedUnit.UNIT;
}