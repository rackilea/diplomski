public abstract class MyRepository<T extends DatabaseObject> {

    private Class<T> type;

    public MyRepository() {
       type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
   ...
 }