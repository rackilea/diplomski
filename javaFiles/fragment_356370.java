public abstract class GenericEntityBean<T extends IntEntity> implements Serializable {

    protected T item;

    public void init(Integer id){
        item.setId(id);
    }
}