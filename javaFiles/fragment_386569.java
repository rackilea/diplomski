// I assume that getAllEvents returns Events class
repository.getAllEvents()
    .flatMapIterable(new Function<Events, Iterable<? extends Event>>() {
        @Override
        public Iterable<? extends Event> apply(@NonNull Events events) throws Exception {
           return events.getEvents();
        }
    })
    .collect(new Callable<HashMap<Date, List<Event>>>() {
        @Override
        public HashMap<Date, List<Event>> call() throws Exception {
            return new HashMap<Date, List<Event>>();
        }}, new BiConsumer<HashMap<Date, List<Event>>, Event>() {
        @Override
        public void accept(@NonNull HashMap<Date, List<Event>> map, @NonNull Event event) throws Exception {
            putEventIntoMap(map, event);
        }}
    )
    ...