public class CardAdapter extends 
    RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private JSONArray mArray;
    private Context mContext;
    private SharedPreferences mPrefs;

    public CardAdapter(Context context) {
        mContext = context;
        mPrefs = context.getSharedPreferences("storeList", Activity.MODE_PRIVATE);
        mArray = new JSONArray(mPrefs.getString("storeList", "[]"));
    }

}