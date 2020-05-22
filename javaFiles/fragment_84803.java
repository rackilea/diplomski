public class SparkSample {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SparkSample")
                .master("local[*]")
                .getOrCreate();

        List<Tuple2<String,String[]>> inputList = new ArrayList<Tuple2<String,String[]>>();
        inputList.add(new Tuple2<String,String[]>("link91",new String[]{"link620","link761"}));
        inputList.add(new Tuple2<String,String[]>("link297",new String[]{"link999","link942"}));
        Dataset<Row> dataset = spark.createDataset(inputList, Encoders.tuple(Encoders.STRING(), spark.implicits().newStringArrayEncoder())).toDF();
        dataset.show(false);    
    }
}