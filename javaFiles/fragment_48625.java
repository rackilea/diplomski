class T {  // A concrete type T
}

interface B<T> {  // warning: The type parameter T is hiding the type T
}

interface A<T> extends B<T> {  // warning: The type parameter T is hiding the type T
    T getObject();
}