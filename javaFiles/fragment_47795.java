final Set<Long> ids = ...; //initialize correctly

    List<CustomObject> results = FluentIterable.from(existingValues).filter(new Predicate<CustomObject>() {
        @Override
        public boolean apply(final CustomObject input) {
            return ids.contains(input.getId());
        }
    }).toList();