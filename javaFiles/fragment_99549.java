public class Movie {
        // ...

        @OneToMany(mappedBy="movie")
        private Set<Genre> genres;
        // getter and setter
    }