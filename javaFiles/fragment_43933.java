public interface IUpdateable
{
    void Update();
}

public abstract class Modul<T> : BasicData, IUpdateable...