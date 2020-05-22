import java.util.Iterator;
import java.util.Map.Entry;
...
Iterator<Entry<Long, Double[]>> iter = table.entrySet().iterator();
while (iter.hasNext()) {
    Entry entry = iter.next();
    rowID = entry.getKey();
    row = entry.getValue();
};