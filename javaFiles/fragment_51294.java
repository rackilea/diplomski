mailItem.advise(
        ItemEvents.class,
        new ItemEvents() {
            @Override
            public void close(Holder<Boolean> cancel) {
                System.out.println("Closed");
            }
        }
    );