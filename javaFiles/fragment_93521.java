Stream<Function<Input, Optional<Output>>> stream = Stream
          .of(classA::eval, classB::eval, classC::eval);
Optional<Output> out = stream.map(f -> f.apply(input))
          .filter(Optional::isPresent)
          .map(Optional::get)
          .findFirst();