import org.apache.spark.api.java.function.Function2;

termsRDD.reduceByKey(new Function2<Integer,Integer,Integer>(){
    @Override
    public Integer call(Integer arg0, Integer arg1) throws Exception {
        return arg0+arg1;
    }
});