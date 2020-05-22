import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;

FilterList fl = new FilterList();
Filter filter = new SingleColumnValueFilter(Bytes.toBytes("columnFamily"), Bytes.toBytes("column"), CompareFilter.CompareOp.GREATER, Bytes.toBytes(dateOfBirth));
fl.add(filter);
scan.setFilter(fl);

ResultScanner rs = table.getScanner(scan);