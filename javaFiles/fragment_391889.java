public class ListsDAO
 {
private Context mContext;
private MyDbAdapter db;

public ListsDAO(Context context)
{
    mContext = context;
    db = new MyDbAdapter(mContext);
}

public List<MyObject> getAllObjects()
{
    List<MyObject> objects = new ArrayList<MyObject>();

    db.open();
    Cursor cursor = db.getAllObjects();     

    if (cursor.moveToFirst())
    {