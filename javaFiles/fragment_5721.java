public class Child extends Parent<ChildDatabase> implements java.lang.AutoCloseable
{

    Child()
    {
        // do something with this.m_d here
    }

    @Override
    ChildDatabase getDatabase()
    {
        return createChildDatabase();
    }
}