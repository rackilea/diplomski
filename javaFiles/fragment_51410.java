public class Test
{
    public static void main(String[] args)
    {
        List objs = new ArrayList<>();
        objs.add(new Test());
        objs.add(new Test());
        Collections.sort(objs);
    }
}