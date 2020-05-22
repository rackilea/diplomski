public void observeAfterCompletion(@Observes(during = AFTER_COMPLETION) Foo someEvent) {
        // this will be notified once the transaction reached AFTER_CEMPLETION stage
    }

    public void observeBeforeCompletion(@Observes(during = BEFORE_COMPLETION) Foo event) {
        // this will be notified once the transaction reaches BEFORE_COMPLETION stage
    }