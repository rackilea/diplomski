DbHelper helper = new DbHelper();

private void DoSimpleInsert()
{
    helper.InsertA(items);
}

private void DoComplexInsert()
{
    helper.BeginTransaction();
    helper.InsertA(items);
    helper.InsertB(items);
    helper.EndTransaction();
}

public class DbHelper
{
    private SQLiteDatabase db;
    private boolean isExpliciteTransaction;
    private ReentrantLock lock = new ReentrantLock();

    public void BeginTransaction()
    {
        isExpliciteTransaction = true;
        db.beginTransaction();
    }

    public void EndTransaction()
    {
        isExpliciteTransaction = false;
        db.endTransaction();
    }

    public void InsertA(ClassA[] items)
    {
        lock.lock();
        try
        {
            if (!isExpliciteTransaction)
            {
                db.beginTransaction();
            }

            // Do the inserts here

            if (!isExpliciteTransaction)
            {
                db.endTransaction();
            }
        }
        finally
        {
            lock.unlock();
        }
    }

    public void InsertB(ClassB[] items)
    {
        lock.lock();
        try
        {
            if (!isExpliciteTransaction)
            {
                db.beginTransaction();
            }

            // Do the inserts here

            if (!isExpliciteTransaction)
            {
                db.endTransaction();
            }
        }
        finally
        {
            lock.unlock();
        }
    }
}