public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    private Context mContext;

    public RVAdapter(Context context) {
            mContext = context;

        }

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cv;
        Context c;
        TextView InvoiceNumber;
        TextView InvoiceType;
        TextView InvoiceDate;
        TextView Status;
        TextView CustomerID;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            InvoiceNumber = (TextView)itemView.findViewById(R.id.invoiceNo);
            InvoiceType = (TextView)itemView.findViewById(R.id.tvType);
            InvoiceDate = (TextView)itemView.findViewById(R.id.tvDate);
            Status = (TextView)itemView.findViewById(R.id.statusTv);
            CustomerID = (TextView)itemView.findViewById(R.id.cutomerId);
            //set OnclickListener
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            //Do whatever you what with the position
            Toast.makeText(mContext, "Clicked Position"+position, Toast.LENGTH_SHORT).show();

        }
    }

    List<Invoice> Invoices;

    RVAdapter(List<Invoice> Invoices){
        this.Invoices = Invoices;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.InvoiceNumber.setText(Invoices.get(i).invoiceNo);
        personViewHolder.InvoiceType.setText(Invoices.get(i).invoiceType);
        personViewHolder.InvoiceDate.setText(Invoices.get(i).invoiceDate);
        personViewHolder.Status.setText(Invoices.get(i).status);
        personViewHolder.CustomerID.setText(Invoices.get(i).cutomerId);

    }

    @Override
    public int getItemCount() {
        return Invoices.size();
    }
}