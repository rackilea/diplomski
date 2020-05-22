public class MyApplication extends Application{

    ArrayList<String> arraylist;

    public static MyApplication instance=null;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    public static MyApplication getInstance()
    {
        if(instance==null)
        {
            instance=new MyApplication();
        }
        return instance;
    }

    public void setArrayListMapData(ArrayList<String> setData)
    {
        arraylist=setData;
    }

    public ArrayList<String> getArrayListMapData()
    {
        return arraylist;

    }

}