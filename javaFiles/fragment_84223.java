public class MyApplication extends Application {

    ArrayList<HashMap<String, String>> arraylist;

    @Override
    public void onCreate() {

        super.onCreate();
    }

    public void setArrayListMapData(ArrayList<HashMap<String, String>> setData)
    {
        arraylist = setData;
    }

    public ArrayList<HashMap<String, String>> getArrayListMapData()
    {
        return arraylist;
    }
}