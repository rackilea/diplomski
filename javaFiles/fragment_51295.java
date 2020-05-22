mailItem.advise(
        ItemEvents.class,
        new ItemEvents() {
            @Override
            public void close(Holder<Boolean> cancel) {
                System.out.println("Getting ready to throw the exception...");
                throw new RuntimeException("ERROR! ERROR!");
            }
        }
    );