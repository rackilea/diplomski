public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public Context mContext;
    public LayoutInflater mInflater;

    public MyAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.row, parent, false);
        //Do your things
    }
}