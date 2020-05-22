private static void solutionWithGenerate()
{
    Result startElement = Result.of(Item.of("start"));

    Result result = Observable.generate(() -> startElement, App::generate)
                              .startWith(startElement)
                              .lastElement()
                              .blockingGet();

    System.out.println(result);
}

private static Result generate(Result previousResult, Emitter<Result> emitter)
{
    Result newResult = Service.callDirectly(previousResult.getItem());

    if (newResult.isEmpty())
    {
        emitter.onComplete();
    } else
    {
        emitter.onNext(newResult);
    }

    return newResult;
}