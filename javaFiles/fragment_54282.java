public class RecyclerViewActivity extends AppCompatActivity { 

private RecyclerView recycler;

@Override 
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view);
    initView(); 

    List<Item> items = Arrays.asList(
            new Item("1", false), 
            new Item("2", false), 
            new Item("3", false), 
            new Item("4", false), 
            new Item("5", false), 
            new Item("6", false), 
            new Item("7", false), 
            new Item("8", false), 
            new Item("9", false), 
            new Item("10", false), 
            new Item("11", false), 
            new Item("12", false), 
            new Item("13", false), 
            new Item("14", false), 
            new Item("15", false), 
            new Item("16", false), 
            new Item("17", false) 
    ); 

    recycler.setAdapter(new ContactsAdapter(items));
    recycler.setLayoutManager(new LinearLayoutManager(this));

} 


class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> { 
    private List<Item> mItems;

    public ContactsAdapter(List<Item> items) {
        mItems = items;
    } 

    @Override 
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.row_recycler, parent, false));
    } 

    @Override 
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    } 

    @Override 
    public int getItemCount() { 
        return mItems.size();
    } 

    class ViewHolder extends RecyclerView.ViewHolder { 
        TextView mTextView;
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.textView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        } 

        void bind(int position) {
            final Item item = mItems.get(position);
            mTextView.setText(item.getText());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override 
                public void onClick(View v) {
                    for (Item item1 : mItems) {
                        item1.setImageVisible(false);
                    } 
                    item.setImageVisible(true);

                    notifyDataSetChanged(); 
                } 
            }); 

            if (item.isImageVisible) mImageView.setVisibility(View.VISIBLE);
            else mImageView.setVisibility(View.INVISIBLE);
        } 
    } 
} 


class Item { 
    private String text;
    private boolean isImageVisible;

    public Item(String text, boolean isImageVisible) {
        this.setText(text);
        this.setImageVisible(isImageVisible);
    } 


    public String getText() {
        return text;
    } 

    public void setText(String text) {
        this.text = text;
    } 

    public boolean isImageVisible() { 
        return isImageVisible;
    } 

    public void setImageVisible(boolean imageVisible) {
        isImageVisible = imageVisible;
    } 
} 

private void initView() { 
    recycler = (RecyclerView) findViewById(R.id.recycler);
} 


}