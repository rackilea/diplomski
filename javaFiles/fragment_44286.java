import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Sample extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        ToolRunner.run(new Sample(), args);
    }

    @Override
    public int run(String[] strings) throws Exception {
        FileSystem fs = FileSystem.get(getConf());
        fs.mkdirs(new Path("/sample/dir"));
        FSDataOutputStream out = fs.create(new Path("/sample/dir/file.txt"));
        out.writeBytes("hello");
        out.close();
        System.out.println(fs.getFileStatus(new Path("/sample/dir/file.txt")).getLen());
        return 0;
    }
}