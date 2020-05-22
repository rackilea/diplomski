public static class MyViewHolder extends RecyclerView.ViewHolder{

    TextView titleTextView;
    //Create the other UI elements here for use in onBindViewHolder()

    public ViewHolder(View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.text_view_title);
        //Initialise other UI elements here
    }
}