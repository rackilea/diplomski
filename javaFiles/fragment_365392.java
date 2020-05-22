import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
... 
Configuration conf = new Configuration(false);
conf.addResource(new Path(System.getProperty("oozie.action.conf.xml")));
String loadType = conf.get("load.type")
...