A<String> as = new A<String>(){};
    A<String> a2s = new A<String>(){};
    A<Integer> ai = new A<Integer>(){};

    as.m(a2s); // prints true
    as.m(ai);  // prints false