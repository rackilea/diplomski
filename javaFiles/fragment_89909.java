class Calculation implements Callable {

    @Override
    public Object call() throws Exception { // The signature can be changed to return a different type (explained at the end)
        return "do complex calculation";
    }
}