public class SparkTest {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("Test").setMaster("local");
        SparkContext sc = new SparkContext(conf);

        PairFunction<String, String,Tuple3<Iterable<String>,Double,Double>> keyData =
                new PairFunction<String,String,Tuple3<Iterable<String>,Double,Double>>() {

            private static final long serialVersionUID = 1L;
            public Tuple2<String, Tuple3<Iterable<String>, Double, Double>> call(String line) throws Exception {    
                return new Tuple2(line.split("\\|")[0], 
                        new Tuple3(Arrays.asList(line.split("\\|")[1].split(",")),
                                Double.parseDouble(line.split("\\|")[2]),Double.parseDouble(line.split("\\|")[3])));
            }
        };

        System.out.println(" --- Input Data ---"); //Data to start with
        JavaPairRDD<String, Tuple3<Iterable<String>,Double,Double>> masterData = 
                sc.textFile("Data\\node.txt", 1).toJavaRDD().mapToPair(keyData);
        masterData.foreach(line -> System.out.println(line));

        Map<String,Double> refData1 = new HashMap<String,Double>();
        Map<String,Iterable<String>> refData2 = new LinkedHashMap<String,Iterable<String>>();
        masterData.collect().forEach(line -> {refData1.put(line._1, line._2._2()); refData2.put(line._1, line._2._1());});
        System.out.println(" --- Referacne Data 1-- "); //stored referance Data node and its 1/n value
        for(String k: refData1.keySet())System.out.println(k + " --> " + refData1.get(k));

        System.out.println(" --- Referacne Data 2-- "); //stored referance Data node and its 1/n value
        for(String k: refData2.keySet()) System.out.println(k + " --> " + refData2.get(k));

        System.out.println(" ---  Data in Step 1 --- ");
        JavaPairRDD<String, Tuple3<Iterable<String>,Double,Double>> step1RDD =
            masterData.mapToPair(line ->new Tuple2(line._1, new Tuple3(getStep1Data(line._1,refData2), line._2._2(), line._2._3())));

        step1RDD.foreach(line -> System.out.println(line)); 

        System.out.println(" --- Data in Step 2 --- ");
        JavaPairRDD<String, Tuple3<Iterable<Double>,Double,Double>> step2RDD =
                step1RDD.mapToPair(line ->new Tuple2(line._1, new Tuple3(getPointsToN(refData1, line._2._1()), line._2._2(), line._2._3())));

        step2RDD.foreach(line -> System.out.println(line)); 
    }
    // get 1/n values from referance Data for pointsTo in new list
    public static Iterable<Double> getPointsToN(Map<String, Double> refData, Iterable<String> pointsTo){
        ArrayList<Double> n1 = new ArrayList<Double>();
        for(String node: pointsTo)
            if(refData.containsKey(node))
                n1.add(refData.get(node)); 
        return n1;
    }
    // get node values from referance Data 2 for pointsTo in new list
        public static Iterable<String> getStep1Data(String node,Map<String, Iterable<String>> refData2){
            ArrayList<String> n1 = new ArrayList<String>();
            for(String n: refData2.keySet())
             refData2.get(n).forEach(element -> {if(element.equals(node)) n1.add(n);});             
            return n1;
        }
}