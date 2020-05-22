public static void main(String[] args)
{
    Integer[] strArray = new Integer[] {1, 2, 3, 4, 5};

    List<Integer> numbers = Arrays.asList(strArray);
    doFunc(numbers, new IFunction<Integer>()
    {
        public void execute(Integer anInt)
        {
            anInt++;
            System.out.println(anInt);
        }
    });
    for (int y = 0; y < numbers.size(); y++)
    {
        System.out.println(numbers.get(y));
    }
}

public static <T> void doFunc(List<T> c, IFunction<T> f)
{
    for (T o : c)
    {
        f.execute(o);
    }
}

public interface IFunction<T>
{
    public void execute(T o);
}