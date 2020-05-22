public class MyMap extends HashMap<MyKey, Data> {

    ListMultimap<Double, Data> mapForBeta;
    ListMultimap<Double, Data> mapForYaw;


    public Data put(MyKey key, Data value) {
        super.put(key, value);
        mapForBeta.add(key.beta, value);
        mapForYaw.add(key.yaw, value);
    };

    public List<Data> getFromBeta(Double beta) {
        return mapForBeta.get(beta);
    }

    public List<Data> getFromYaw(Double yaw) {
        return mapForYaw.get(yaw);
    }
}