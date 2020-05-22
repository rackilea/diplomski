import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class TestSpark {

    public static void main(String args[])
    {
       // String[] jars = {"D:\\customJars\\spark.jar"};
       // System.setProperty("hadoop.home.dir", "D:\\hadoop-common-2.2.0-bin-master");
        SparkConf sparkConf = new SparkConf().setAppName("spark.TestSpark").setMaster("local");
                //.setMaster("spark://10.1.50.165:7077")
                //.setJars(jars);

        JavaSparkContext jsc = new JavaSparkContext(sparkConf);
        //SQLContext sqlcon = new SQLContext(jsc);
        String inputFileName = "forecaster.txt" ;
        JavaRDD<String> logData = jsc.textFile(inputFileName);
        long numAs = logData.filter(new Function<String, Boolean>() {

            @Override
            public Boolean call(String s) throws Exception {
                return s.contains("a");
            }
        }).count();

        long numBs = logData.filter(new Function<String, Boolean>() {

            public Boolean call(String s) { return s.contains("b"); }
            }).count();

         System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
        System.out.println("sadasdasdf");

        jsc.stop();
        jsc.close();
    }

}