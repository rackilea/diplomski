@Stateless(name="DataAccessBean", mappedName="ejb/DataAccessBean")
@Remote(DataAccessRemote.class)
@Local(DataAccessLocal.class)
public class DataAccess implements DataAccessLocal, DataAccessRemote {
    ...
}