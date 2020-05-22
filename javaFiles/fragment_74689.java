public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

private List<Items> itemsList;
private Activity activity;

public CardAdapter(Activity activity, List<Items> items){
    this.activity = activity;
    this.itemsList = items;
}

@Override
public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = activity.getLayoutInflater().inflate(R.layout.cardview_layout, parent, false);
    return new CardViewHolder(itemView);
}

@Override
public void onBindViewHolder(CardViewHolder holder, int position) {
    //Here you bind your views with the data from each object from the list
}

@Override
public int getItemCount() {
    return itemsList.size();
}

public class CardViewHolder extends RecyclerView.ViewHolder {

    public ImageView bookImage;
    public TextView bookLabel01, bookLabel02;

    public CardViewHolder(View itemView) {
        super(itemView);
        bookImage = (ImageView)itemView.findViewById(R.id.image);
        bookLabel01 = (TextView)itemView.findViewById(R.id.label01);
        bookLabel02 = (TextView)itemView.findViewById(R.id.label02);
    }
}