public interface IClonable
    {
        void Clone();
    }

    public interface IDisposable
    {
        void Dispose();
    }

    public class MyClass : IClonable, IDisposable
    {
        void IClonable.Clone()
        {

        }
        void IDisposable.Dispose()
        {

        }
    }