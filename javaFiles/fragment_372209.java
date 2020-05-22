AnotherClass ac = new AnotherClass();

ac.listeners.add(new SomeEventListener<Integer>() {
    void eventOccurred(SomeEvent<Integer> event) {
        System.out.println(event.intValue());
    }
});

SomeEvent<String> event = new SomeEvent<String>("Hello");
ac.fireSomethingOccursEvent(event);