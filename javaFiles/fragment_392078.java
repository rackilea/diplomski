public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder>{

    private ArrayList<owner> ownerlist;
    private Context mContext;

    public customAdapter(Context c , ArrayList<owner> p) {
        this.mContext = c;
        this.ownerlist = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int 
    viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.prospectowners,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        owner owner = ownerlist.get(position);

        holder.name.setText(owner.getName());
        holder.field.setText(owner.getFieldname());
        holder.mobile.setText(owner.getMobile());
        holder.address.setText(owner.getAddress());
        holder.cost.setText(owner.getCost());
    }

    @Override
    public int getItemCount() {
        return ownerlist.size();
    }

    public void addData(ArrayList<owner> newData){
        this.ownerlist.addAll(newData);
        notifyOnDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView field;
        public TextView mobile;
        public TextView address;
        public TextView cost;

       public MyViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.field =  itemView.findViewById(R.id.fieldName);
            this.mobile =  itemView.findViewById(R.id.mobileowner);
            this.address =  itemView.findViewById(R.id.address);
            this.cost =  itemView.findViewById(R.id.cost);
        }
    }
}