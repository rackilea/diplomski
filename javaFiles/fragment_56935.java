import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AReducer.class)
public class TestAReducer {

    @Test
    public void reducerMRUnit() throws IOException{
        ReduceDriver reduceDriver = new ReduceDriver(new AReducer());
        String output = "";
        ArrayList<Text> list = new ArrayList<Text>(0);
        list.add(new Text(""));
        reduceDriver.withInput(new Text(""), list);
        reduceDriver.withPathOutput(new Text(output), NullWritable.get(), "filename");
        reduceDriver.runTest();
    }
}