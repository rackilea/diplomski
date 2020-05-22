import Java.util.ArrayList;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
public class CustomerFileReader implements ItemStreamReader<Object> {
private Object curItem = null;
private ItemStreamReader<Object> delegate;
public Object read() throws Exception {
if(curItem == null) {
curItem = (Customer) delegate.read();
}
Customer item = (Customer) curItem;
curItem = null;
if(item != null) {
item.setTransactions(new ArrayList<Transaction>());
while(peek() instanceof Transaction) {
curItem = null;
}
}
return item;
}
public Object peek() throws Exception, UnexpectedInputException,
ParseException {
if (curItem == null) {
curItem = delegate.read();
}
return curItem;
}
public void setDelegate(ItemStreamReader<Object> delegate) {
this.delegate = delegate;
}
public void close() throws ItemStreamException {
delegate.close();
}
public void open(ExecutionContext arg0) throws ItemStreamException {
delegate.open(arg0);
}
public void update(ExecutionContext arg0) throws ItemStreamException {
delegate.update(arg0);
}
}