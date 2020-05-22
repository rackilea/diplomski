public class LeaveAdapter extends RecyclerView.Adapter<LeaveAdapter.MyViewHolder> {
Activity activity;
ArrayList<LeaveModel> list;

public LeaveAdapter(Activity activity, ArrayList<LeaveModel> list) {
    this.activity = activity;
    this.list = list;
}

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_leaveadapter, parent, false);
    return new MyViewHolder(rootView);
}

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    String leaveStatus = list.get(position).getLeaveStatus();
    if (leaveStatus.equals("Panding for approval")) {
        holder.img_LeaveAdapter_highlight.setBackgroundColor(ContextCompat.getColor(activity, R.color.Red));

    } else if (leaveStatus.equals("Approved")) {
        holder.img_LeaveAdapter_highlight.setBackgroundColor(ContextCompat.getColor(activity, R.color.Green));

    }
}

@Override
public int getItemCount() {
    return list.size();
}

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView img_LeaveAdapter_highlight;

    public MyViewHolder(View itemView) {
        super(itemView);
        img_LeaveAdapter_highlight = itemView.findViewById(R.id.img_LeaveAdapter_highlight);
    }
}
}