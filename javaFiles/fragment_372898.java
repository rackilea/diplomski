@Subscribe
public void parentEventHandler(ParentEvent parentEvent) {
    NestedEvent nestedEvent = createNestedEvent();
    eventBus.post(nestedEvent);
    eventBus.post(new InternalEventCallback() {
        @Override
        public void run() {
            if(nestedEvent.isCancelled()) {
                return;
            }

            Object anotherNestedEvent = createOtherNestedEvent();
            eventBus.post(anotherNestedEvent);
        }
    });
}