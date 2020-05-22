void process() throws RuntimeException
{
    try {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        ints.forEach(LambdaExceptions.rethrowConsumer(e -> {
            System.out.println(e);
            throw new RuntimeException("RuntimeException");
        }));

    }
    catch (RuntimeException rex)
    {
        System.out.println("Got first exception");
        rex.printStackTrace();
        throw rex;
    }
}