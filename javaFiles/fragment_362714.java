abstract class AbstractExecutor<E> {

    public void execute() throws Exception {
        List<E> list = new ArrayList<E>();
        E e = create("Gate");
        list.add(e);
        System.out.println(format(list));
    }

    public abstract E create(String name);

    // ...
}