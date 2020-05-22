public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {

    Context context;
    ArrayList<String> list;

    public Adapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Adapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_groups, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String groupName = list.get(getAdapterPosition());
                Intent intentUserProfile = new Intent(context, MainActivity.class);
                intentUserProfile.putExtra("groupChatName", groupName);
                // If fixed, you should pass these values to adapter's constructor
                // intentUserProfile.putExtra("neighbourhood", neighbourhood);
                // intentUserProfile.putExtra("usersName", usersName);
                // intentUserProfile.putExtra("usersID", usersID);
                context.startActivity(intentUserProfile);
            }
        };

        public MyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(onClickListener);
            nameTextView = (TextView) itemView.findViewById(R.id.groupChatNameTxt);
        }

        public void setText(String groupName) {
            nameTextView.setText(groupName);
        }
    }
}