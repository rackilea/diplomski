Flowable<Integer> integerFlowable = Flowable.fromIterable(foos)
    .map(s -> {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    });