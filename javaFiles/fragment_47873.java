SparkConf conf = new SparkConf();
conf.set("spark.kryo.registrator", "org.apache.spark.examples.MyRegistrator");
...

public class MyRegistrator implements KryoRegistrator {
    public void registerClasses(Kryo kryo) {
        kryo.register(Year4D.class);
    }
}