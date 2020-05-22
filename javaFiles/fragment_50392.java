public class MyQueryAdapter extends ParseRecyclerQueryAdapter<MY_MODEL, MyQueryAdapter.MyViewHolder>{


    public MyQueryAdapter(boolean hasStableIds) {
        super(MY_MODEL.class, hasStableIds);
    }

public MarcacionesAdapter(ParseQueryAdapter.QueryFactory<Marcaciones> factory, boolean hasStableIds) {
        super(factory, hasStableIds);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        MY_MODEL model = getItem(position);
        holder.name.setText(model.getName());
        holder.year.setText(model.getYear());

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView year;

        MyViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            name = (TextView)itemView.findViewById(R.id.name);
            year = (TextView)itemView.findViewById(R.id.year);
        }
    }

}