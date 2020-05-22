QueueConnectionFactory factory = ...;

    Dispatcher dispatcher =
            new Dispatcher(
            factory,
            "Queue_Original",
            new String[]{
                "Consumer_Queue_1",
                "Consumer_Queue_2",
                "Consumer_Queue_3"});
    dispatcher.start();