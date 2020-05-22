import java.util.ArrayList;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class IniFileItemReader implements ItemStreamReader<Object> {

    private Object curItem = null;
    private ItemStreamReader<Object> delegate;

    @Override
    public Object read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        if (curItem == null) {
            curItem = (Section) delegate.read();
        }

        Section section = (Section) curItem;
        curItem = null;

        if (section != null) {
            section.setProperties(new ArrayList<Property>());

            while (peek() instanceof Property) {
                section.getProperties().add((Property) curItem);
                curItem = null;
            }
        }
        return section;
    }

    private Object peek() throws Exception {
        if (curItem == null) {
            curItem = delegate.read();
        }
        return curItem;
    }

    public void setDelegate(ItemStreamReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public void open(ExecutionContext arg0) throws ItemStreamException {
        delegate.open(arg0);
    }

    @Override
    public void update(ExecutionContext arg0) throws ItemStreamException {
        delegate.update(arg0);
    }
}