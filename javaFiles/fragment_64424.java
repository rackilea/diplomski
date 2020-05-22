@UseStringTemplate3StatementLocator
public abstract class MyDAO {

    @SqlQuery("select * from table where type in (<types>) and date = :Date  ")
    public abstract List<xx> get(@Define("types") String types);

....