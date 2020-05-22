Optional<Output> out = Stream.of(
                (<Function<Input, Optional<Output>>>)classA::eval, 
                classB::eval, 
                classC::eval)
        .map(f -> f.apply(input))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .findFirst();