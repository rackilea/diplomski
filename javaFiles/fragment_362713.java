abstract class AbstractExecutor<E> {

    public void execute() throws Exception {
        List<E> list = new ArrayList<E>();
        Class<E> cls = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        E e = cls.getConstructor(String.class).newInstance("Gate");
        list.add(e);
        System.out.println(format(list));
    }

    // ...
}