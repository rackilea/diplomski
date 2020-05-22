public class CompositeCursorItemReader<T> implements ItemStreamReader<T> {

/** Registered ItemStreamReaders. */
private List<AbstractCursorItemReader<?>> cursorItemReaders;
/** Mandatory Unifying Mapper Implementation. */
private UnifyingItemsMapper<T> unifyingMapper;

@Override
public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    // read from all registered readers
    List items = new ArrayList();
    for (AbstractCursorItemReader<?> cursorItemReader : cursorItemReaders) {
        items.add(cursorItemReader.read());
    }
    // delegate to mapper
    return unifyingMapper.mapItems(items);
}
}