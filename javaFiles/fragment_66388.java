class JsonEntity {

    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "JsonEntity [movies=" + movies + "]";
    }
}

class Movie {

    private String title;
    private Profile in_wanted;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Profile getIn_wanted() {
        return in_wanted;
    }

    public void setIn_wanted(Profile in_wanted) {
        this.in_wanted = in_wanted;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", in_wanted=" + in_wanted + "]";
    }
}

class Profile {

    private boolean value;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}