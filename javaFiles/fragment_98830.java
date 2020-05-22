public class ListWrapperProcessor<I,O> implements ItemProcessor<List<I>, List<O>> {

    ItemProcessor<I,O> delegate;

    public void setDelegate(ItemProcessor<I,O> delegate) {
        this.delegate = delegate;
    }


    public List<O> process(List<I> itemList) {
        List<O> outputList = new ArrayList<>();

        for (I item : itemList){    
           O outputItem = delegate.process(item);
           if (outputItem!=null) {
               outputList.add(outputItem);
           }
        }

        if (outputList.isEmpty()) {
            return null;
        }

        return outputList;
    }

}


public class ListOfListItemWriter<T> implements InitializingBean, ItemStreamWriter<List<T>> {

    private ItemStreamWriter<T> itemWriter;

    @Override
    public void write(List<? extends List<T>> listOfLists) throws Exception {
        if (listOfLists.isEmpty()) {
            return;
        }

        List<T> all = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());

        itemWriter.write(all);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(itemWriter, "The 'itemWriter' may not be null");
    }

    public void setItemWriter(ItemStreamWriter<T> itemWriter) {
        this.itemWriter = itemWriter;
    }

    @Override
    public void close() {
        this.itemWriter.close();
    }

    @Override
    public void open(ExecutionContext executionContext) {
        this.itemWriter.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) {
        this.itemWriter.update(executionContext);
    }
}