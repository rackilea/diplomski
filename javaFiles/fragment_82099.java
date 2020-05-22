public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
private static final String TAG = "RecyclerViewAdapter";
private Context context;
private List<Upload> uploads;
Menu menu;
private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);
public ItemsAdapter(Context context, List<Upload> uploads) {
    this.uploads = uploads;
    this.context = context;
}
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items, parent, false);
    ViewHolder holder = new ViewHolder(v);
    return holder;
}
@Override
public void onBindViewHolder(ViewHolder holder, final int position) {
    Log.d(TAG, "onBindViewHolder: called.");
    final Upload upload = uploads.get(position);
    holder.textViewName.setText(upload.getName());
    holder.textdescription.setText(upload.getDescription());
    holder.textcost.setText( "Ksh" + upload.getCost());
    holder.buy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: clicked on: " + uploads.get(position));
            //add what you want done when the button clicked here
            });
    Glide.with(context).load(upload.getUrl()).into(holder.imageView);
}
@Override
public int getItemCount() {
        return uploads.size();
}
public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView textViewName, textdescription, textcost;
    public ImageView imageView;
    public Button buy;
    public ViewHolder(View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textdescription = itemView.findViewById(R.id.textdescription);
        textcost = itemView.findViewById(R.id.textcost);
        imageView = itemView.findViewById(R.id.imageView);
        buy = itemView.findViewById(R.id.addToCart);
        }
    }
}