collect(foos, Foo::f);

public List<String> collect(List<Foo> foos, Function<Foo,String> func)
{
    List<String> result = new ArrayList<String>();

    for (final Foo foo: foos) {
        result.add(func.apply(foo));
    }

    return result;
}