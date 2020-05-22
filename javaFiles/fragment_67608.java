@Provides
FooInterface provideFooImplementation(
        Provider<FooImpl1> impl1,
        Provider<FooImpl2> impl2,
        ...,
        Provider<FooImpl10> impl10) {
    switch(state) {
        case STATE_1:
            return impl1.get();
        case STATE_2:
            return impl2.get();
        ...
        case STATE_10:
            return impl10.get();
    }
}