@Autowire
MyIdsPartitioner partitioner;

public void someMethod() {
    ...
    partitioner.setIds(someIds);
    partitioner.setFromIndex(fromIndex);
    partitioner.setToIndex(toIndex);
    ...
}