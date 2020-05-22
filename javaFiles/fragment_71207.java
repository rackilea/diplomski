@UseStringTemplate3StatementLocator
public interface ThingieDao {
    @SqlQuery
    @MapResultAsBean
    Iterator<Thingie> search(@Define("criteria") String criteria);
}