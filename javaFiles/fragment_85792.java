public static Predicate<Task> startDateFilteringWithDate(final Date date) {
    return new Predicate<Task>() {
        @Override
        public boolean apply(Task input) {
            return input.getStartDate() != null
                && input.getStartDate().after(date);
        }
    };
}