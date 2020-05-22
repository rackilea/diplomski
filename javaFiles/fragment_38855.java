public class MySuperList<T>
{
    // Add method will only accept instances of type T.
    public void Add(T a) { }
}

// Your code
MySuperList<Cars> list = new MySuperList<Cars>();
cars.Add(new Car("Ford Mondeo"));// Works
cars.Add(new Fish("Herring")); // Compile-time error.