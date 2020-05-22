public class StorageClass {
    private static Map<String,String> arrayData = new HashMap<>();

    public static void setArrayData(Map<String,String> results){
        arrayData = results;
    }

    public static Map<String, String> getArrayData(){
        return arrayData;
    }
}