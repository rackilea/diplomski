class ContactViewHolder extends RecyclerView.ViewHolder  {

    public TextView contactName,contactNumber;
    public ImageButton removeContact;
    private  List<Contact> contacts1;
    private ContactsAdapter contactsAdapter1;

    public ContactViewHolder(View itemView, ContactsAdapter contactsAdapter, final List<Contact> contacts) {
        super(itemView);
        this.contacts1=contacts;
        this.contactsAdapter1=contactsAdapter;
        contactName= (TextView) itemView.findViewById(R.id.tv_contactName);
        contactNumber= (TextView) itemView.findViewById(R.id.tv_contactNumber);
        removeContact= (ImageButton) itemView.findViewById(R.id.ib_removeItem);
        removeContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts1.remove(getPosition());
                contactsAdapter1.notifyItemRemoved(getPosition());
            }
        });
    }
}