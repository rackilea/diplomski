public abstract class AbstractCrud<T extends Entity> {
    private GenericTableModel<T> table;

    public AbstractCrud( GenericTableModel<T> table ){ this.table = table }

    public List<T> getList(){
        return this.table.listAll()
    }



public class UserSimpleCrud extends AbstractCrud<User> {
    public UserSimpleCrud(){
        super( new UsersTable() );
    }