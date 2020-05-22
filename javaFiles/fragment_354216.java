public static <U> EventFactory<Event<U>> factory() {
    return new EventFactory<Event<U>>() {
        public Event<U> newInstance() {
            return new Event<U>();
        }
    };
}