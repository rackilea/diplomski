public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

private final Context mContext;
List<String> data;

public MyAdapter(Context context, List<String> mdata) {
    this.data = mdata;
    this.mContext = context;
}

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    int layoutId = R.layout.rec_item;
    LayoutInflater inflater = LayoutInflater.from(mContext);
    View itemView = inflater.inflate(layoutId, parent, false);
    return new MyViewHolder(itemView);
}

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    LayoutInflater inflater = LayoutInflater.from(mContext);
    final int questions_count = 5;
    for (int i = 0; i < questions_count; i++) {
        View questionNumberView = inflater.inflate(R.layout.item_question_number, holder.container, false);
        TextView textView = questionNumberView.findViewById(R.id.text_question_number);
        textView.setText(String.valueOf(i));
        holder.container.addView(questionNumberView);
    }
}

@Override
public int getItemCount() {
    return data.size();
}

public static class MyViewHolder extends RecyclerView.ViewHolder {
    ViewGroup container;
    public MyViewHolder(View itemView) {
        super(itemView);
        container = itemView.findViewById(R.id.questions_container);
    }

}