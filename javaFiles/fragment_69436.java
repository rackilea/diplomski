public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> mSingleItemLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_single_item);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setDummyData() {
        for (int i = 0; i <= 1000; i++)
            mSingleItemLists.add("item" + i);
        SingleListItemAdapter singleListItemAdapter = new SingleListItemAdapter(mSingleItemLists);
        mRecyclerView.setAdapter(singleListItemAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setDummyData();
    }

    class SingleListItemAdapter extends RecyclerView.Adapter<SingleListItemAdapter.SingleListItemHolder> {
        private ArrayList<String> mSingleItemLists;

        private SingleListItemAdapter(ArrayList<String> singleItemLists) {
            mSingleItemLists = singleItemLists;
        }

        @Override
        public SingleListItemAdapter.SingleListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflatedView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_recyclerview, parent, false);
            return new SingleListItemHolder(inflatedView);
        }

        @Override
        public void onBindViewHolder(SingleListItemAdapter.SingleListItemHolder holder, int position) {
            holder.mItemDate.setText(mSingleItemLists.get(position));
            holder.mItemImageView.setImageResource(R.mipmap.ic_launcher_round);
        }

        @Override
        public int getItemCount() {
            return mSingleItemLists.size();
        }

        class SingleListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView mItemDate;
            private ImageView mItemImageView;

            SingleListItemHolder(View v) {
                super(v);
                mItemDate = (TextView) v.findViewById(R.id.textview_recycler_list_item);
                mItemImageView = (ImageView) v.findViewById(R.id.imageview_icon);
                v.setOnClickListener(this);
                this.setIsRecyclable(false);
            }

            @Override
            public void onClick(View v) {
                //do your stuff
                notifyDataSetChanged();
            }
        }
    }

}