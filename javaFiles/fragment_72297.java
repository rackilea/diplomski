public class Connection{
    Context mContext;
    public Connection(Context context) {
        // TODO Auto-generated constructor stub

         mContext = context;
    }

    public void test(){
        Toast.makeText(mContext, "This is a test", Toast.LENGTH_SHORT).show();
    }
}