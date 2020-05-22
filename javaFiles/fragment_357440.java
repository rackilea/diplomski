public class MyRowProcessor<T> implements RowProcessor {

    private final BeanListProcessor<T> wrappedProcessor;

    public MyRowProcessor(Class<T> beanType) {
        wrappedProcessor = new BeanListProcessor<T>(beanType);
    }


    @Override
    public void processStarted(ParsingContext context) {
        wrappedProcessor.processStarted(context);
    }


    @Override
    public void rowProcessed(String[] row, ParsingContext context) {
        //validate the input row here
        if(row.length != context.headers().length){
            return; // Example: I'm skipping the row if the number of columns doesn't match number of headers
        }

        //send the row to the wrapped processor (or skip, or do anything you want)
        wrappedProcessor.rowProcessed(row, context);
    }

    @Override
    public void processEnded(ParsingContext context) {
        wrappedProcessor.processEnded(context);
    }

    public List<T> getBeans() {
        return wrappedProcessor.getBeans();
    }
}