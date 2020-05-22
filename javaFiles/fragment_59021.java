public class MyData {

    private static MyData sMyData;
    private Context mAppContext;
    private String mExamplePayload;

    private MyData(Context c){
        mAppContext = c.getApplicationContext();
        mExamplePayload = "You can access this string from any Activity or Fragment";
    }

    public static MyData get(Context c){
        if (sMyData==null){
            sMyData = new MyData(c);                
        }
        return sMyData;
    }

    public String getPayload() {
        return mExamplePayload;
    }   
}