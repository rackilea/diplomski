import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import java.util.*;
import org.apache.spark.sql.DataFrame;
import static org.apache.spark.sql.functions.*;

public class App {
  public static void main(String[] args) {
    JavaSparkContext sc = new JavaSparkContext(new SparkConf());
    SQLContext sqlContext = new HiveContext(sc);
    List<String> data = Arrays.asList(
            "{\"id\": 1, \"vs\": [\"a\", \"b\"]}",
            "{\"id\": 1, \"vs\": [\"c\", \"d\"]}",
            "{\"id\": 2, \"vs\": [\"e\", \"f\"]}",
            "{\"id\": 2, \"vs\": [\"g\", \"h\"]}"
    );
    DataFrame df = sqlContext.read().json(sc.parallelize(data));
    df.withColumn("vs", explode(col("vs")))
           .groupBy(col("id"))
           .agg(collect_list(col("vs")))
           .show();
  }
}