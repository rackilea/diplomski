public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        //Do your things
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        //Do your things
    }
}