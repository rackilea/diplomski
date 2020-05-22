public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CardView cv;
    TextView title;
    TextView dueDt;

    public Button searchBtn, renewBtn, returnBtn;

    PersonViewHolder(View itemView) {
        super(itemView);

        cv = (CardView) itemView.findViewById(R.id.cv);
        title = (TextView) itemView.findViewById(R.id.title);
        dueDt = (TextView) itemView.findViewById(R.id.dueDate);
        renewBtn = (Button) itemView.findViewById(R.id.renew_button);
        returnBtn = (Button) itemView.findViewById(R.id.checkin_button);

        renewBtn.setOnClickListener(this);    // <- This lines
        returnBtn.setOnClickListener(this);   // <- This lines
    }

    (...)

}