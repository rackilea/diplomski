import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.TaskAttemptID;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl;
import org.apache.hadoop.util.ReflectionUtils;
import java.io.File;

Configuration conf = new Configuration(false);
conf.set("fs.default.name", "file:///");

File testFile = new File("path/to/file");
Path path = new Path(testFile.getAbsoluteFile().toURI());
FileSplit split = new FileSplit(path, 0, testFile.length(), null);

InputFormat inputFormat = ReflectionUtils.newInstance(MyInputFormat.class, conf);
TaskAttemptContext context = new TaskAttemptContextImpl(conf, new TaskAttemptID());
RecordReader reader = inputFormat.createRecordReader(split, context);

reader.initialize(split, context);