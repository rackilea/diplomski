interface ICalcSomethingStrategy {
    public double CalcSomething(IFoo, IAnotherClass);
}

CalcSomethingStrategyFactory {
    ICalcSomethingStrategy CreateCalcSomethingStrategy(IFoo foo) {
        // I'm not sure whether this is the idiomatic java way to check types D:
        if (foo.Bar instanceof UpBar && foo instanceof Yip) {
            return new UnusualCalcSomethingStrategy();
        } else {
            return new StandardCalcSomethingStrategy();
        }
    }
}