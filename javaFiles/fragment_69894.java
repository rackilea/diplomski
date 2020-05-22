public A(T t) {
        a = (A<T>) new B();
        //  ^^^^^^ NB: This will at least give a rawtype warning
        //             as it causes heap pollution.
        a.t = t;
    }