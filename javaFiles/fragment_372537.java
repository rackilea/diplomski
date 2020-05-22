public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

private ListListener listener;
private List<ItemView> items;
private Context context;

public ListAdapter(List<ItemView> items, Context context) {
    this.items = items;
    this.context = context;
}

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_style, parent, false);
    return new ViewHolder(view);
}

public ItemView getItem(int pos) {
    return items.get(pos);
}

public void setListener(ListListener listener) {
    this.listener = listener;
}

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    ItemView i = items.get(position);

    holder.setHeadText(i.getHead());
    holder.setScoreText(i.getContent());

    holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                if (listener != null && pos != RecyclerView.NO_POSITION) {
                    listener.onClick(pos);
                }
            }
    });

    holder.itemLayout.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        int pos = holder.getAdapterPosition();
                        if (pos != -1) {
                            if (listener != null) {
                                listener.onLongClick(getItem(pos));
                            }
                        }
                        return true;
                    }
                });
}