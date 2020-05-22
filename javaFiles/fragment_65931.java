interface IBase { }
interface IGenericInterface<T> : IBase { }
class MyClass : IGenericInterface<string> { }

class MyContainer {
    List<IBase> impl = new List<IBase>();

    void Main() {
        impl.Add(new MyClass());
    }
}