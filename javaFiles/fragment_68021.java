abstract class Model<T> {
    abstract public void setId(T id);

    abstract public T getId();
}

class SQLiteModel extends Model<Integer> {
    private Integer id;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}