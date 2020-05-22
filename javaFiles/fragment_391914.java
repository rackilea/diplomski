public class MyCustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

public static final int ROW_VIEW = 0;
public static final int CHILD_VIEW = 1;

ArrayList<ItemInterface> finalList;
WeakReference<Context> mContextWeakReference;

public MyCustomAdapter(ArrayList<ItemInterface> finalList, Context context) {
    this.finalList = finalList;
    this.mContextWeakReference = new WeakReference<Context>(context);
}

@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    Context context = mContextWeakReference.get();
    if (viewType == ROW_VIEW) {
        return new SectionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false));
    }
    return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child, parent, false), context);
}

@Override
public int getItemViewType(int position) {
    if (finalList.get(position).isRow()) {
        return ROW_VIEW;
    } else {
        return CHILD_VIEW;
    }
}

@Override
public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

    Context context = mContextWeakReference.get();

    if (context == null) {
        return;
    }

    if (ROW_VIEW == getItemViewType(position)) {

        SectionViewHolder sectionViewHolder = (SectionViewHolder) holder;
        ScreenOneRows screenOneRows = (ScreenOneRows) finalList.get(position);
        sectionViewHolder.textView.setText(screenOneRows.getSequence_title());
        sectionViewHolder.textView2.setText(screenOneRows.getSequence_description());
        return;
    }

    MyViewHolder myViewHolder = (MyViewHolder) holder;
    ScreenOneInventory childInventory = (ScreenOneInventory) finalList.get(position);
    myViewHolder.textView.setText(childInventory.getName());
    myViewHolder.textView2.setText(childInventory.getDescription());

}


@Override
public int getItemCount() {
    //return mUsersAndSectionList.size();
    return finalList.size();
}

//holder
public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textView, textView2;
    ImageView image;

    public MyViewHolder(View itemView, final Context context) {

        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        textView2 = itemView.findViewById(R.id.textView2);
        image = itemView.findViewById(R.id.image);
    }
}

public class SectionViewHolder extends RecyclerView.ViewHolder {
    TextView textView, textView2;
    ImageView image;

    public SectionViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        textView2 = itemView.findViewById(R.id.textView2);
        image = itemView.findViewById(R.id.image);
    }


 }