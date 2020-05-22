public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Information> mList;
    private FragmentCommunication mCommunicator;

    public RecyclerAdapter(Context context, List<Information> list,FragmentCommunication communication) {
        inflater = LayoutInflater.from(context);
        mList = list;
        mCommunicator=communication;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view,mCommunicator);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final Information current = mList.get(position);
        holder.name.setText(current.name);
        holder.job.setText(current.job);

        FragmentB fragmentB=new FragmentB();
        Bundle bundle=new Bundle();
        bundle.putString("NAME",current.name);
        bundle.putString("JOB",current.job);
        fragmentB.setArguments(bundle);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView job;
        FragmentCommunication mComminication;

        public MyViewHolder(View itemView, FragmentCommunication Communicator) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            job = (TextView) itemView.findViewById(R.id.tv_gob);
            mComminication=Communicator;
            name.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mComminication.respond(getAdapterPosition(),mList.get(getAdapterPosition()).name,mList.get(getAdapterPosition()).job);
        }
    }
}