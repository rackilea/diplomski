public class DB<T>{
    private Class<T> type;
    public DB(Class<T> type){this.type = type;}

    public List<T> getList() throws IllegalAccessException, InstantiationException {
        return Arrays.asList(type.newInstance(), type.newInstance());
    }
}