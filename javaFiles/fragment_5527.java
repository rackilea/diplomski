public abstract class BaseClass<T> : IBaseClass<T>
{
    public MyIterator<T> Search(T e)
    {
        //Do something here
    }

    IEnumerator<T> IBaseClass<T>.Search(T e)
    {
        return Search(e);
    }
}