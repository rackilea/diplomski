public abstract class Clonable
    {
        public abstract void Clone();
    }

    public abstract class Disposable
    {
        public abstract void Dispose();
    }

    // MyClass cannot be Disposable too, it is not allowed by the language

    public class MyClass : Clonable
    {
        override void Clone()
        {

        }
    }