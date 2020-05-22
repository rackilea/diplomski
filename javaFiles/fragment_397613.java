@lombok.Data
class FooBarData {
    private final String foo;
    private final String bar;
}

@lombok.Data
class FizzBuzzData {
    private final String fizz;
    private final String buzz;
}

class FooBarService {
    public FooBarData invoke() {
        System.out.println("This is an expensive FooBar call");
        return new FooBarData("FOO", "BAR");
    }
}

class FizzBuzzService {
    public FizzBuzzData invoke() {
        System.out.println("This is an expensive FizzBuzz call");
        return new FizzBuzzData("FIZZ", "BUZZ");
    }
}