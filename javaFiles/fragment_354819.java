@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    RecyclerView.ViewHolder vh = null;
    if(viewType == 1){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout_one,parent,false);
        vh = new MyViewHolder_LayoutOne(view);
    }else if(viewType == 2){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout_two,parent,false);
        vh = new MyViewHolder_LayoutTwo(view);
    }
    return vh;
}