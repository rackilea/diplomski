public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<String> mMacList;
    SafeDB mDB;
    Context mContext;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mMac;
        public Button mSafe;
        public Button mUnsafe;

        public MyViewHolder(View view) {
            super(view);
            mMac = view.findViewById(R.id.name);
            mSafe = view.findViewById(R.id.marksafe);
            mUnsafe = view.findViewById(R.id.markunsafe);
        }
    }

    public MyAdapter(Context context,ArrayList<String> maclist) {
        mMacList = maclist;
        mContext = context;
        mDB = new SafeDB(context);

        // Could add the mac's to the DB here (note DB changed so mac is unqiue so same mac won't be added)
        for (String mac: maclist) {
            mDB.addSafeMaker(mac,0);
        }
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mylist_item,viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        mContext = viewGroup.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, int i) {
        viewHolder.mMac.setText(mMacList.get(i));
        if (mDB == null) {
           mDB = new SafeDB(viewHolder.mMac.getContext());
        }
        //Set the Tag for the buttons with the mac so it can be retrieved
        viewHolder.mSafe.setTag(mMacList.get(i));
        viewHolder.mUnsafe.setTag(mMacList.get(i));

        // Display the buttons according to the database
        if (mDB.getSafeValue(mMacList.get(i))) {
            viewHolder.mSafe.setVisibility(View.GONE);
            viewHolder.mUnsafe.setVisibility(View.VISIBLE);
        } else {
            viewHolder.mSafe.setVisibility(View.VISIBLE);
            viewHolder.mUnsafe.setVisibility(View.GONE);
        }
        // Add the onCLickListeners
        viewHolder.mSafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.mSafe.setVisibility(View.GONE);
                viewHolder.mUnsafe.setVisibility(View.VISIBLE);
                String mac = (String) ((Button) viewHolder.mSafe).getTag();
                changeSafeMark((String)viewHolder.mSafe.getTag(),0);
            }
        });
        viewHolder.mUnsafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.mSafe.setVisibility(View.VISIBLE);
                viewHolder.mUnsafe.setVisibility(View.GONE);
                changeSafeMark((String)viewHolder.mUnsafe.getTag(),1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMacList.size();
    }

    public int changeSafeMark(String mac, int mark) {
        int result = mDB.updateMaker(mac,mark);
        return result;
    }
}