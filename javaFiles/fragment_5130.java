public class WishListAdapter extends 
     RecyclerView.Adapter<WishListAdapter.DerpHolder> {

    private List<WishListItem> listData;
    private LayoutInflater inflater;
    Context context;

    public WishListAdapter(List<WishListItem> listData, Context c) {
        inflater = LayoutInflater.from(c);
        this.listData = listData;
        this.context = c;
    }

    @Override
    public WishListAdapter.DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.wish_list_item, parent, false);
        return new DerpHolder(view);
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {

    }

    public void setListData(ArrayList<WishListItem> exerciseList) {
        this.listData.clear();
        this.listData.addAll(exerciseList);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DerpHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView thumbnail;
        TextView title;
        TextView subTitle;
        View container;


        public DerpHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.im_item_icon);

            //subTitle = itemView.findViewById(R.id.lbl_item_sub_title);

            //title = itemView.findViewById(R.id.lbl_item_text);

            container = itemView.findViewById(R.id.cont_item_root);
            container.setOnClickListener(this);
            Picasso.with(context ).load("http://i.imgur.com/DvpvklR.png").into(thumbnail);
        }

        @Override
        public void onClick(View v) {
            Log.d("janitha", "item clicked");

        }