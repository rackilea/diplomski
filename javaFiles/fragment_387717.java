@Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    private static SupervisorStrategy strategy =
            new OneForOneStrategy(10, Duration.create("1 minute"),
                    t -> {
                        if (t instanceof SomeException) {
                            return restart();
                        } else {
                            return stop();
                        }
                    });