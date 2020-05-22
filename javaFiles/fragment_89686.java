public class ValidatingItemProcessor implements ItemProcessor<Input, AbstractItem>, StepExecutionListener {

    private boolean itemFailed = false;

    @Override
    public AbstractItem process(final Input item) throws Exception {
        if (item.isValid()) {
            return new GoodItem();
        }
        itemFailed = true;
        return new BadItem();
    }

    @Override
    public void beforeStep(final StepExecution stepExecution) {
        //no-op
    }

    @Override
    public ExitStatus afterStep(final StepExecution stepExecution) {
        if (itemFailed) {
            return new ExitStatus("3");
        }
        return null;
    }
}