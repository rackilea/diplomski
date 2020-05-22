import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DomainCountWritable implements Writable {
    private Text domain;
    private IntWritable count;

    public DomainCountWritable() {
        this.domain = new Text();
        this.count = new IntWritable(0);
    }

    public DomainCountWritable(Text domain, IntWritable count) {
        this.domain = domain;
        this.count = count;
    }

    public Text getDomain() {
        return this.domain;
    }

    public IntWritable getCount() {
        return this.count;
    }

    public void setDomain(Text domain) {
        this.domain = domain;
    }

    public void setCount(IntWritable count) {
        this.count = count;
    }

    public void readFields(DataInput in) throws IOException {
        this.domain.readFields(in);
        this.count.readFields(in);
    }

    public void write(DataOutput out) throws IOException {
        this.domain.write(out);
        this.count.write(out);
    }

    @Override
    public String toString() {
        return this.domain.toString() + "\t" + this.count.toString();
    }
}