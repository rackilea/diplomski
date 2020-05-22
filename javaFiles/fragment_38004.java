Collections.sort(movieList, new Comparator<Movie>() {
            @Override
            public int compare(Movie lhs, Movie rhs) {
                return Integer.parseInt(lhs.getPosition()) - Integer.parseInt((rhs.getPosition()));
            }
        });