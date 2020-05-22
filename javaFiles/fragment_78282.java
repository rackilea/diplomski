@Stateless
public class MovieEJB
{
  @PersistenceContext(unitName = "movieDS")
    private EntityManager em;

    @Override
    public Movie create(Movie movie) throws Exception
    {
        em.persist(movie);
        return movie;
    }

    @Override
    public void delete(Movie movie)
    {
        em.remove(em.merge(movie));
    }

    @Override
    public Movie update(Movie movie) throws Exception
    {
        return em.merge(movie);
    }
}