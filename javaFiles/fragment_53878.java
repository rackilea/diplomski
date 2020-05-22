public class Adaptor extends ClickableAdapter<Adaptor.viewholder> {
private String[] data;

public Adaptor(String[] data) {
    this.data = data;
}


@Override
public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.list_item1, parent, false);
    return new viewholder(view);
}

@Override
public void onBindViewHolder(viewholder holder, final int position) {
    super.onBindViewHolder(holder,position);
    String title = data[position];
    holder.t.setText(title);

}

@Override
public int getItemCount() {
    return data.length;
}

public class viewholder extends RecyclerView.ViewHolder {
    ImageView i;
    TextView t;

    public viewholder(View itemView) {
        super(itemView);
        i = itemView.findViewById(R.id.img1);
        t = itemView.findViewById(R.id.main1);
    }
}

   }