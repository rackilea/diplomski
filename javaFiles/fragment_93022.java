Steam<B> converted = original.flatMap( a -> { 
    if(a.split()){
        return Stream.of(new B(a), new B(a));
    } else {
        return Stream.of(new B(a));
    }
});