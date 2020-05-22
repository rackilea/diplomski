public static void main(String[] args) throws IOException, ClassNotFoundException {
    final List<Film> films = new ArrayList<>();
    films.add(new Film().setRating(1));
    films.add(new Film().setRating(2.5));
    films.add(new Film().setRating(3.5));
    films.add(new Film().setRating(4));
    films.add(new Film().setRating(5));
    films.add(new Film().setRating(1));
    films.add(new Film().setRating(2));
    films.add(new Film().setRating(3));
    films.add(new Film().setRating(4));
    System.out.println(films);
    Collections.sort(films, new Comparator<Film>() {
        @Override
        public int compare(Film o1, Film o2) {
            return Double.compare(o1.getRating(), o2.getRating());
        }
    });
    System.out.println(films);
}