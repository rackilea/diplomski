public class Video<A extends Actor> {
    protected List<A> actors;

    public List<A> getActors() { return actors; }
}

public class Movie extends Video<MovieActor> {}

public class TVSerie extends Video<TVSerieActor> {}