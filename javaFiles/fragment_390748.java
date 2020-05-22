// apache commons
mangas = CollectionUtils.filter(mangas, new Predicate() {
    @Override public boolean evaluate(Object object) {
        return ((Manga) manga).getGenre() != null;
    }
});

// Guava 
Iterables.filter(mangas, new Predicate<Manga>() {
    @Override public boolean apply(Manga m) {
        return manga.getGenre() != null;
    }
});