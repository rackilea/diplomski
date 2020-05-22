Foo[] foos = // some Foo array
Bar[] bars = 
    ArrayUtils.transformArray(
        Bar.class,
        foos,
        new Transformer<Foo, Bar>() {
            public Bar transform(Foo foo) { return new Bar(foo); } 
        }
    );