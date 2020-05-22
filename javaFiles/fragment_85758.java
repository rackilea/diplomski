import java.util.Properties;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

SparkConf sparkConf = new SparkConf()
JavaSparkContext ctx = new JavaSparkContext(sparkConf);

InputStream inputStream;
Path pt = new Path("hdfs:///user/hadoop/myproperties.properties");
FileSystem fs = FileSystem.get(ctx.hadoopConfiguration());
inputStream = fs.open(pt);

Properties properties = new Properties();
properties.load(inputStream);