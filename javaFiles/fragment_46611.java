public interface Foo
{
    public default void bar()
    {
         this.bar(1);
    }

    public void bar(int i);
}