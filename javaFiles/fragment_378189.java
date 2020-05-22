class Something<Bob> {
    void Method1(Bob parameter){} // refers to the generic type parameter Bob

    void Method2(Boby parameter){} // refers to the Boby class
}

class Something<Boby> {
    void Method(Boby parameter){} // refers to the generic type parameter Boby,
                                  // hiding the Boby class
}

class Something<T> {
    void Method(Bob parameter){} // compilation error - Bob is an undefined symbol
}