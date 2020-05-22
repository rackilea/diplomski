public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ViewHolder> {
List<Conversation> conversations;

public ConversationAdapter(List<Conversation> conversations) {
    this.conversations = conversations; 
}

public ConversationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
    // create a new view
    TextView v = (TextView) LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_view, parent, false);
    ...
    MyViewHolder vh = new MyViewHolder(v);
    return vh;
}
// Replace the contents of a view (invoked by the layout manager)
@Override
public void onBindViewHolder(MyViewHolder holder, int position) {
Conversation conversation = conversations.get(position);
holder.mTextView.setText(conversation.getConversationText());   

}

// Return the size of your dataset (invoked by the layout manager)
@Override
public int getItemCount() {
    return conversations.size();
}

public static class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView mTextView;

    public MyViewHolder(TextView v) {
        super(v);
        mTextView = v;
    }
}