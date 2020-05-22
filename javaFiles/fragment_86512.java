@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ActorSpec {

public static Specification<Actor> query(final Long movieId, String name) {
    return (root, query, cb) -> {
        Predicate predicateMovieID = getPredicateByMovieId(movieId, root, query, cb);

        if (Strings.isNotBlank(name)) {
            Predicate a = cb.and(predicateMovieID, cb.equal(root.get("firstName"), name));
            Predicate b = cb.and(predicateMovieID, cb.equal(root.get("lastName"), name));
            return cb.or(a,b);
        }
        return cb.and(predicateMovieID);
    };
}

private static Predicate getPredicateByMovieId(Long movieId, Root<Actor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
    query.distinct(true);
    Subquery<Movie> movieSubQuery = query.subquery(Movie.class);
    Root<Movie> movie = movieSubQuery.from(Movie.class);
    Expression<List<Actor>> actors = movie.get("actors");
    movieSubQuery.select(movie);
    movieSubQuery.where(cb.equal(movie.get("movieId"), movieId), cb.isMember(root, actors));
    return cb.exists(movieSubQuery);
    }
}