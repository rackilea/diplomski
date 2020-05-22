public abstract class Parent<DB extends Database>
{
    DB m_d;

    Parent()
    {
        m_d = getDatabase();
    }

    abstract DB getDatabase();
}