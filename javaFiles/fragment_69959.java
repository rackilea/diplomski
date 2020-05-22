import java.util.*;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

public final class extractSubject {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local[1]").setAppName("JavaBookExample");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        //JavaRDD<String> sample = sc.textFile("/Users/Desktop/sample.txt");
        JavaRDD<String> sample = sc.parallelize(Arrays.asList("Subject: first",
                                                              "nothing here",
                                                              "Subject: second",
                                                              "dummy"));

        JavaRDD<String> subjectLinesRdd = sample.flatMap(new FlatMapFunction<String, String>() {
            public Iterable<String> call(String line) {
                if (line.contains("Subject:")) {
                    return Collections.singletonList(line);  // line matches → return list with the line as its only element
                } else {
                    return Collections.emptyList();  // ignore line → return empty list
                }
            }
        });

        List<String> subjectLines = subjectLinesRdd.collect();  // collect values from Spark workers
        System.out.println(subjectLines);  // → "[Subject: first, Subject: second]"

        sc.stop();
    }
}