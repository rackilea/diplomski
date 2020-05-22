public void iterate_array(T[] items)
{
    iterate(Arrays.asList(items));
}

public void iterate_array(Iterable<T> items)
{
    for (T t : items)
        do_something(t);    
}