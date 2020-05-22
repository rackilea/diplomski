toReturn = Iterables.find(articles, new Predicate<Object>() {
    public boolean apply(Object item) {
            return item.toString().equals(input);
    }

    public boolean equals(Object obj) {
        // check whether the other object is also a Predicate
    }
});