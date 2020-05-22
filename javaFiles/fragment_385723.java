public class ListHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private static final int TYPE_HEADER = 0;
private static final int TYPE_ITEM = 1;
ArrayList<String> data;

public ListHeaderAdapter (ArrayList<String> data) {
    this.data = data;
}

@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if (viewType == TYPE_ITEM) {
        //inflate your layout and pass it to view holder
        return new VHItem(null);
    } else if (viewType == TYPE_HEADER) {
        //inflate your layout and pass it to view holder
        return new VHHeader(null);
    }
}

@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
 int pos = position - 1; // for handling of Header view(use pos to fetch data from list)

    if (holder instanceof VHItem) {
        String dataItem = data.get(pos);
        //cast holder to VHItem and set data
    } else if (holder instanceof VHHeader) {
        //cast holder to VHHeader and set data for header.
    }
}

@Override
public int getItemCount() {
    return data.size()+ 1; // for handling of Header view
}

@Override
public int getItemViewType(int position) {
    if (isHeader(position))
        return TYPE_HEADER;

    return TYPE_ITEM;
}

public boolean isHeader(int position) {
    return position == 0;
}


class VHItem extends RecyclerView.ViewHolder {
    TextView title;

    public VHItem(View itemView) {
        super(itemView);
    }
}

class VHHeader extends RecyclerView.ViewHolder {
    Button button;

    public VHHeader(View itemView) {
        super(itemView);
    }
}
}