class Foo {
    List<Object> objects = new List<Object>(); 
    void foo(Object o) { 
        objects.add(o); 
    }
}

// ...

Foo f = new Foo(); 
f.foo(new Object()); // The object we just created is not eligible for garbage 
                     // collection until the `Foo f` is not used, because
                     // it holds a strong reference to the object.