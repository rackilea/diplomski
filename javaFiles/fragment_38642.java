public interface ICrudManager<T extends IndexedEntity> {

    public void add(T e);

    public IndexedEntity get(long id);

    public void update(T e);

    public void delete(T e);

    public List<T> getAll();

}